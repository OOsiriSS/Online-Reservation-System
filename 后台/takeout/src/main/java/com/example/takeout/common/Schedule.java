package com.example.takeout.common;

import com.example.takeout.entity.Orders;
import com.example.takeout.entity.Restaurant;
import com.example.takeout.mapper.OrdersMapper;
import com.example.takeout.mapper.PaymentdetailsMapper;
import com.example.takeout.mapper.PreferentialMapper;
import com.example.takeout.mapper.RestaurantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class Schedule {

    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private PreferentialMapper preferentialMapper;
    @Autowired
    private PaymentdetailsMapper paymentdetailsMapper;
    @Autowired
    private RestaurantMapper restaurantMapper;

    /**
     * 扫描过期的订单,将超过有效时间的订单状态修改
     */
    @Scheduled(fixedDelay = 5000)
    public void start(){
        ordersMapper.updateOverdueOrders();
    }

    /**
     * 扫描活动表,将过期的活动从数据库删除
     */
    @Scheduled(fixedDelay = 5000)
    public void deletePreferentia(){
        preferentialMapper.deletePreferentia();
    }

    //平台将收到的钱结算给餐厅
    @Scheduled(fixedDelay = 5000)
    public void findSettlementTest(){
        List<Integer> stay = paymentdetailsMapper.findSettlement();
        ss(stay);
    }

    //将所有要结算给商家的订单查出来 然后依次结算
    private void ss(List<Integer> stay){
        if (stay.size()==0)
            return;
        for (int i = 0;i<stay.size();i++){
            Orders orders = ordersMapper.selectByPrimaryKey(stay.get(i));
            settlement(orders);
        }

    }

    //给商家结算
    private void settlement(Orders orders){
        BigDecimal money = orders.getOrderTotal();
        Integer restaurantId = orders.getRestaurantId();
        Restaurant restaurant = restaurantMapper.selectByPrimaryKey(restaurantId);
        BigDecimal balance = restaurant.getRestaurantBalance();
        balance = balance.add(money);
        restaurant.setRestaurantBalance(balance);
        restaurantMapper.updateMerchantsInfo(restaurant);
        updatePaymentStatus(orders.getOrderId());
    }

    //结算成功后将订单状态改为已结算
    private void updatePaymentStatus(Integer orderId){
        paymentdetailsMapper.updatePaymentStasus(orderId);
    }
}
