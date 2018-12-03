package com.wefed.mybatis.dao;

import org.apache.ibatis.annotations.Mapper;

import com.wefed.mybatis.entities.User;

@Mapper
public interface UserDao {

	User get(long id);
}
