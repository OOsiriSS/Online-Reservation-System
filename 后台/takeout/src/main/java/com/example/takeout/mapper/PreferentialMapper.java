package com.example.takeout.mapper;

import com.example.takeout.entity.Preferential;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * PreferentialMapper继承基类
 */
@Repository
public interface PreferentialMapper extends MyBatisBaseDao<Preferential, Integer> {


    int deletePreferentia();

    @Select(value = {"SELECT ratio FROM preferential WHERE goods_id=#{goodsId}"})
    BigDecimal findDiscount(@Param("goodsId") Integer goodsId);

}