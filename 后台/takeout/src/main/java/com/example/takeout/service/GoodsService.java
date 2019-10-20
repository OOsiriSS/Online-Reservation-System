package com.example.takeout.service;

import com.example.takeout.common.JSONResult;
import com.example.takeout.mapper.GoodsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {

    @Autowired
    private GoodsDAO goodsDAO;

    /**
     * 根据商家id查询商品
     * @param id
     * @return
     */
    public JSONResult findProductByRestaurant(Integer id){
        return JSONResult.ok(goodsDAO.findProductByRestaurant(id));
    }




}
