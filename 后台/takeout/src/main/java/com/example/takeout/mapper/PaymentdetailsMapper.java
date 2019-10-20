package com.example.takeout.mapper;

import com.example.takeout.entity.Paymentdetails;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * PaymentdetailsMapper继承基类
 */
@Repository
public interface PaymentdetailsMapper extends MyBatisBaseDao<Paymentdetails, Integer> {

    public static final String TABLE = "paymentdetails";

    public static final String SELECT_FIELD =
    "payment_details_id as paymentDetailsId, user_id as userId, order_money as orderMoney, status as status, order_id as orderId";


//    @Update(value = {"UPDATE ", TABLE, " SET status=501 WHERE order_id=#{orderID}"})
//    int refund(@Param("orderID") Integer orderID);

    @Select(value = {"SELECT ",SELECT_FIELD, " FROM ", TABLE, " WHERE order_id=#{orderID}"})
    Paymentdetails findPaymentById(@Param("orderID") Integer id);


    int updateByPrimaryKeySelective(Paymentdetails paymentdetails);


    @Select(value = {"SELECT SUM(order_money) FROM ",TABLE, " WHERE status!=501 AND user_id=#{userID}"})
    BigDecimal consumption(@Param("userID") Integer userId);


    //查询出待结算给餐厅尾款的订单号
    @Select(value = {"SELECT ", " order_id ", " FROM ", TABLE, " WHERE status=0"})
    List<Integer> findSettlement();

    //给商家结算成功后将结算状态改为已结算(1)
    @Update(value = {"UPDATE ", TABLE, " SET status=1 WHERE order_id=#{orderId}"})
    List<Integer> updatePaymentStasus(@Param("orderId") Integer orderId);
}