package com.ydl.springboot.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ydl.springboot.entity.User;

@Mapper
@Repository
public interface UserDao {
//	@Select(" SELECT * FROM user  WHERE user_name=#{name}")
//	@ResultType(User.class)
	public  List<User> getUsers(String name); 
}

 