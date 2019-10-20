package com.example.takeout.mapper;

import com.example.takeout.entity.Orders;
import com.example.takeout.entity.User;
import com.example.takeout.vo.OrdersVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * OrderMapper继承基类
 */
@Repository
public interface OrdersMapper extends MyBatisBaseDao<Orders, Integer> {

    public static final String TABLE = "orders";

    public static final String SELECT_FIELD =
            "order_id as orderId, user_id as userId, createTime as createtime," +
            " restaurant_id as restaurantId, order_describe as orderDescribe, order_total as orderTotal, order_status as orderStatus";


    int insertSelective(Orders orders);

    int updateByPrimaryKeySelective(Orders orders);

    Orders selectByPrimaryKey(Integer id);

    List<Orders> findUserOrder(User user);

    int updateOverdueOrders();


    @Select(value = {"SELECT SUM(order_total) FROM ",TABLE, " WHERE restaurant_id=#{restaurantID} AND createTime >= #{start} AND createTime <= #{end}"})
    BigDecimal findByInterval(@Param("restaurantID") Integer id, @Param("start") Timestamp start, @Param("end") Timestamp end);


    @Select(value = {"SELECT * FROM `orders` o, `restaurant` r WHERE o.user_id=#{userID} AND o.restaurant_id = r.restaurant_id"})
    List<OrdersVO> findInfo(@Param("userID") Integer userID);


    @Select(value = {"SELECT ", SELECT_FIELD, "FROM ", TABLE, "WHERE user_id=#{userID} AND order_status=501"})
    List<Orders> findRefund(@Param("userID") Integer userID);

    @Select(value = {"SELECT * FROM `orders` o,`address` a WHERE o.restaurant_id=#{restId} AND O.order_status = 200 AND a.address_id = o.address_id "})
    List<OrdersVO> findMealrecord(Integer restId);
}