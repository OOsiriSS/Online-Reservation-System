package com.example.takeout.mapper;

import com.example.takeout.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


/**
 * UserMapper继承基类
 */
@Repository
@Mapper
public interface UserMapper extends MyBatisBaseDao<User, User> {
    public static final String TABLE = "user";
    public static final String SELECT_FIELD = "user_id as userId,user_name as userName, user_email as userEmail, user_pass as userPass, user_level userLevel, user_status as userStatus, balance as balance";


    @Select(value = {"SELECT ",SELECT_FIELD ," FROM  ", TABLE ," WHERE user_email = #{useremail} and user_pass = #{password}"})
    User toLogin(@Param("useremail") String userEmail,@Param("password") String userPass);

    @Update(value = {"UPDATE",TABLE,"SET user_status=1 WHERE user_email=#{useremail}"})
    int updateByEmail(@Param("useremail") String userEmail);


    @Update(value = {"UPDATE",TABLE ,"SET user_status=0 WHERE user_email=#{usermail}"})
    int updateCancellation(@Param("usermail") String userEmail);

    @Select(value = {"SELECT ",SELECT_FIELD, " FROM ", TABLE, " WHERE user_id=#{userID}"})
    User findUserById(@Param("userID") Integer id);

    int updateUser(User user);

    @Select(value = {"SELECT COUNT(user_id) FROM ",TABLE})
    int userStatistical();


}