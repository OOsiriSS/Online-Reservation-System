package com.example.takeout.service;

import com.example.takeout.common.JSONResult;
import com.example.takeout.entity.Admin;
import com.example.takeout.entity.Goods;
import com.example.takeout.mapper.AdminDAO;
import com.example.takeout.mapper.GoodsDAO;
import com.example.takeout.mapper.RestaurantMapper;
import com.example.takeout.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminDAO adminDAO;

    @Autowired
    private GoodsDAO goodsDAO;

    @Autowired
    private RestaurantMapper restaurantMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * 管理员登陆
     * @param account
     * @param password
     * @return
     */
    public JSONResult adminLogin(String account,String password){
        Admin admin = adminDAO.toLogin(account, password);
        if(null == admin)
            return JSONResult.errorMsg("登陆失败,请重试!");
        else
            return JSONResult.ok(admin);
    }




    /**
     * 管理员注册
     * @param admin
     * @return
     */
    public JSONResult adminRegister(Admin admin){
        return JSONResult.ok(adminDAO.insert(admin));
    }


    /**
     * 查询所有未审核的商品信息
     * @return
     */
    public JSONResult notAuditList(){
        return JSONResult.ok(goodsDAO.findNOtAudit());
    }

    /**
     * 无条件分页查询未审核信息
     * @param pageNum
     * @return
     */
    public JSONResult pageNotAuditList(Integer pageNum){
        PageHelper.startPage(pageNum,2);
        List<Goods> nOtAudit = goodsDAO.findNOtAudit();
        PageInfo<Goods> pageInfo = new PageInfo<>(nOtAudit,2);
        return JSONResult.ok(pageInfo);
    }


    /**
     * 通过id修改需要审核的商品信息
     * @param id
     * @return
     */
    public JSONResult passAudits(Integer id){
        int matched = goodsDAO.updataStatusById(id);
        if (matched==1)
            return JSONResult.ok(matched);
        else
            return JSONResult.errorMsg("审核出错");
    }

    /**
     *
     * @return
     */
    public JSONResult restaurantStatistical(){
        return JSONResult.ok(restaurantMapper.findRestaurantCount());
    }


    public JSONResult userStatistical(){
        return JSONResult.ok(userMapper.userStatistical());
    }
}
