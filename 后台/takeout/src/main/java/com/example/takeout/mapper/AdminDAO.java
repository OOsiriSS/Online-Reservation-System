package com.example.takeout.mapper;


import com.example.takeout.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * AdminDAO继承基类
 */
@Repository
@Mapper
public interface AdminDAO extends MyBatisBaseDao<Admin, Integer> {

    public static final String TABLE = "admin";
    public static final String SELECT_FIELD = "admin_id as adminId, admin_user as adminUser, admin_pass as adminPass";

    @Select(value = {"SELECT", SELECT_FIELD, "FROM", TABLE, "WHERE admin_user = #{adminUser} AND admin_pass = #{adminPass}"})
    Admin toLogin(@Param("adminUser") String account, @Param("adminPass") String password);

}