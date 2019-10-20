package com.example.takeout.mapper;


import com.example.takeout.entity.Type;
import org.springframework.stereotype.Repository;

/**
 * TypeDAO继承基类
 */
@Repository
public interface TypeDAO extends MyBatisBaseDao<Type, Integer> {
}