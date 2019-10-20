package com.example.takeout.service;

import com.example.takeout.common.JSONResult;
import com.example.takeout.common.MailUtil;
import com.example.takeout.constant.OrderStatus;
import com.example.takeout.constant.PaymentStatus;
import com.example.takeout.entity.*;
import com.example.takeout.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private OrderdetailsMapper orderdetailsMapper;
    
    @Autowired
    private GoodsDAO goodsDAO;

    @Autowired
    private PaymentdetailsMapper paymentdetailsMapper;

    @Autowired
    private PreferentialMapper preferentialMapper;

    /**
     * 用户登陆
     * @param userEmail 邮箱
     * @param userPass 密码
     * @return
     */
    public JSONResult login(String userEmail,String userPass) {
        User user = userMapper.toLogin(userEmail, userPass);
        if (null == user)
            return JSONResult.errorMsg("登陆失败");
        if (user.getUserStatus()==0)
            return JSONResult.errorMsg("账户未激活,不能登陆");
        else
            return JSONResult.ok(user);
    }


    /**
     * 用户注册
     * @param user
     * @return
     * @throws UnsupportedEncodingException
     * @throws MessagingException
     */
    public JSONResult register(User user) throws UnsupportedEncodingException, MessagingException {
        int insert = userMapper.insert(user);
        if(insert == 1){
            Base64.Encoder encoder = Base64.getEncoder();
            byte[] textByte = user.getUserEmail().getBytes("UTF-8");
            String code = encoder.encodeToString(textByte);
            MailUtil.sendMailMessage(user.getUserEmail(),"用户激活","http://localhost:8080/user/activate?code="+code);
        }

        return JSONResult.ok();
    }

    /**
     * 账户激活
     * @param code 邮箱的加密码
     * @return
     * @throws UnsupportedEncodingException
     */
    public JSONResult activate(String code) throws UnsupportedEncodingException {
        Base64.Decoder decoder = Base64.getDecoder();
        String email = new String(decoder.decode(code), "UTF-8");//解密后的邮箱
        userMapper.updateByEmail(email);
        return JSONResult.ok();
    }


    /**
     * 账户注销
     * @param email 注销的账户
     * @return
     */
    public JSONResult cancellation(String email){
        int matched = userMapper.updateCancellation(email);
        if(matched == 1)
            return JSONResult.ok();
        else
            return JSONResult.errorMsg("注销失败");
    }


    /**
     * 修改用户信息
     * @param userId
     * @param userName
     * @param userPass
     * @return
     */
    public JSONResult updateUser(Integer userId,String userName,String userPass){
        User user = userMapper.findUserById(userId);
        user.setUserName(userName);
        user.setUserPass(userPass);

        int matched = userMapper.updateUser(user);
        if(matched!=0)
            return JSONResult.ok();
        else
            return JSONResult.errorMsg("修改失败!");
    }

    /**
     * 查询该用户下的有效订单(未支付部分)
     * @param user
     * @return
     */
    public JSONResult findUserOrder(User user){
        return JSONResult.ok(ordersMapper.findUserOrder(user));
    }

    /**
     * 确认收货
     * @param orders
     * @return
     */
    public JSONResult confirmOrder(Integer ordersId){
        Orders orders = ordersMapper.selectByPrimaryKey(ordersId);
        orders.setOrderStatus(OrderStatus.CONFIRM.value);
        return JSONResult.ok(ordersMapper.updateByPrimaryKeySelective(orders));
    }

    /**
     * 退款,支付订单后已发货和已确认的的订单不能退款
     * @param ordersID
     * @return
     */
    public JSONResult refund(Integer ordersID){
        Orders orders = ordersMapper.selectByPrimaryKey(ordersID);
        Integer status = orders.getOrderStatus();
        if (400 != status)
            return JSONResult.errorMsg("该订单还未支付,不能退款");
//        if (200 == status)
//            return JSONResult.errorMsg("订单已确认,无法退款");
//        if (300 == status)
//            return JSONResult.errorMsg("商品正在发出,无法退款");
        else {
            orders.setOrderStatus(OrderStatus.UNSUBSCRIBE.value);
            ordersMapper.updateByPrimaryKeySelective(orders);
            reimburse(ordersID);
        }
        return JSONResult.ok("退订成功,情等待收款");
    }

    /**
     * 根据id将支付状态改为退款状态,并将钱退给用户
     * @return
     */
    public JSONResult reimburse(Integer orderID){
        //改支付状态
        Paymentdetails payment = paymentdetailsMapper.findPaymentById(orderID);
        payment.setStatus(PaymentStatus.REFUND.value);
        //退款
        User user = userMapper.findUserById(payment.getUserId());
        BigDecimal balance = user.getBalance();
        balance = balance.add(payment.getOrderMoney());
        user.setBalance(balance);
        userMapper.updateUser(user);

        return JSONResult.ok(paymentdetailsMapper.updateByPrimaryKeySelective(payment));
    }



    /**
     * 保存订单到数据库中
     * @param goods
     * @return
     */
    public JSONResult saveOrders(List<Goods> goods,Integer userId,Integer addressId){
        Orders order = createOrders(goods,userId,addressId);
        for (int i = 0;i<goods.size();i++){
            //this
            Goods product = goods.get(i);
//            Integer restaurantId = product.getRestaurantId();
//            Orders order = orders.get(restaurantId);

            Orderdetails details = new Orderdetails();
            details.setGoodsId(product.getGoodsId());
            details.setOrderId(order.getOrderId());
            details.setDetailsStock(1);

            orderdetailsMapper.insertSelective(details);
        }
        return JSONResult.ok(order.getOrderId());
    }


    /**
     * 根据用户选择了不同商家,得出相应应该需要创建订单号的条数
     * @param goods
     * @return
     */
    private Orders createOrders(List<Goods> goods,Integer userId,Integer addressId){
//        Set<Integer> restaurantIdmap = new HashSet<>();
//        for (int i = 0;i<goods.size();i++){
//            Integer id = goods.get(i).getRestaurantId();
//            restaurantIdmap.add(id);
//        }
//        Map<Integer,Orders> orders = new HashMap<>();

        //创建应该有的订单
//        for (Integer i : restaurantIdmap) {
            Orders order = new Orders();

            long l = System.currentTimeMillis();
            Timestamp timestamp = new Timestamp(l);
            order.setCreatetime(timestamp);

            order.setRestaurantId(goods.get(0).getRestaurantId());
            order.setOrderStatus(OrderStatus.UNCONFIRMED.value);
            order.setUserId(userId);
            order.setAddressId(addressId);
            ordersMapper.insertSelective(order);

//            orders.put(i,order);
//        }
        return order;
    }


    /**
     * 提交订单,扣除用户金额,修改订单状态
     * @param orderId
     * @param userID
     * @return
     */
    public JSONResult commitOrder(Integer orderId,Integer userID) {
        User user = userMapper.findUserById(userID);
        List<Orderdetails> details = orderdetailsMapper.findDetailsByOrderId(orderId);

        Orders order = ordersMapper.selectByPrimaryKey(orderId);
        if (order.getOrderStatus() == 500)
            return JSONResult.errorMsg("该订单已过期");

        BigDecimal total = calculateTotal(details);
        BigDecimal balance = user.getBalance();
        if (1 == balance.compareTo(total)){
            order.setOrderStatus(OrderStatus.WAIT.value);
            order.setOrderTotal(total);
            //修改订单状态为以付款
            ordersMapper.updateByPrimaryKeySelective(order);
            //结算扣钱
            return payment(total,user,order);
        }
        else {
            return JSONResult.errorMsg("余额不足");
        }
    }


    /**
     * 根据详情计算出订单中的总金额
     * @param orderdetails
     * @return
     */
    private BigDecimal calculateTotal(List<Orderdetails> orderdetails){
        BigDecimal total = new BigDecimal(0);
        for (Orderdetails d : orderdetails) {
            Integer productId = d.getGoodsId();
            Goods product = goodsDAO.findGoodsById(productId);
            BigDecimal discount = isDiscount(product.getGoodsId());
            //判断该商品是否有优惠折扣
            BigDecimal price = null;
            if (null != discount) {
                price = price.multiply(discount);
            }
            else
                price = product.getGoodsPrice();
            BigDecimal multiply = price.multiply(new BigDecimal(1));
            total = total.add(multiply);
        }
        return total;
    }

    /**
     * 判断当前商品是否有折扣优惠
     * @param goodsId
     * @return
     */
    public BigDecimal isDiscount(Integer goodsId){
        return preferentialMapper.findDiscount(goodsId);
    }

    /**
     * 结算扣钱
     * @param total
     * @param user
     * @return
     */
    private JSONResult payment(BigDecimal total,User user,Orders orders){
        BigDecimal balance = user.getBalance();
        BigDecimal subtract = balance.subtract(total);
        //扣用户的钱
        user.setBalance(subtract);
        userMapper.updateUser(user);
        //把钱支付给yummy,此时交易金额不会到商家手上,由系统规则自动将金额分配给商家
        Paymentdetails payment = new Paymentdetails();
        payment.setOrderMoney(total);
        payment.setOrderId(orders.getOrderId());
        payment.setUserId(user.getUserId());
        payment.setStatus(0);
        paymentdetailsMapper.insert(payment);

        return JSONResult.ok();
    }


    /**
     * 用户查看个人的消费总计金额
     * @param userId
     * @return
     */
    public JSONResult consumption(Integer userId){
        return JSONResult.ok(paymentdetailsMapper.consumption(userId));
    }


    /**
     * 查看具体消费信息(订单)
     * @param userId
     * @return
     */
    public JSONResult consumptionInfo(Integer userId){
        return JSONResult.ok(ordersMapper.findInfo(userId));
    }

    /**
     * 查看退订信息(订单)
     * @param userId
     * @return
     */
    public JSONResult findRefund(Integer userId){
        return JSONResult.ok(ordersMapper.findRefund(userId));
    }

}
