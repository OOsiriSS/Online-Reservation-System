package com.example.takeout.mapper;

import com.example.takeout.entity.Orderdetails;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * OrderdetailsMapper继承基类
 */
@Repository
public interface OrderdetailsMapper extends MyBatisBaseDao<Orderdetails, Integer> {



    List<Orderdetails> findDetailsByOrderId(Integer ordersId);

}