package com.ydl.springboot.server.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ydl.springboot.dao.UserDao;
import com.ydl.springboot.entity.User;
import com.ydl.springboot.server.UserService;
import com.ydl.springboot.server.YdlService;


@Service
public class UserServiceImpl  extends YdlService implements UserService {
	
	@Autowired
    UserDao postDao;
    
	@Override
	public  List<User> getUsers(String name) {
		// TODO Auto-generated method stub
		return postDao.getUsers(name);
	}
}
