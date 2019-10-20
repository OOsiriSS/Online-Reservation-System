package com.example.takeout.mapper;

import com.example.takeout.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * AddressMapper继承基类
 */
@Repository
@Mapper
public interface AddressMapper extends MyBatisBaseDao<Address, Integer> {

    public static final String TABLE = "address";
    public static final String SELECT_FIELD = "address_id as addressId,address_value as addressValue,user_id as userId,address_phone as addressPhone";


    List<Address> findByUserId(Integer userId);


    int updateById(Address address);

}