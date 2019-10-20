package com.example.takeout.service;

import com.example.takeout.common.JSONResult;
import com.example.takeout.entity.Address;
import com.example.takeout.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@CrossOrigin
public class AdderssServer {

    @Autowired
    private AddressMapper addressMapper;


    /**
     * 查出用户下的收货地址及电话
     * @param userId
     * @return
     */
    public JSONResult addressList(Integer userId){
        List<Address> byUserId = addressMapper.findByUserId(userId);
        return JSONResult.ok(byUserId);
    }

    /**
     * 根据id修改收货信息
     * @param address
     * @return
     */
    public JSONResult updateAddressById(Address address){
        int matched = addressMapper.updateById(address);
        if (matched==1)
            return JSONResult.ok();
        else
            return JSONResult.errorMsg("修改失败");
    }

    /**
     *
     * @param address
     * @return
     */
    public JSONResult addAddress(Address address){
        return JSONResult.ok(addressMapper.insert(address));
    }



}
