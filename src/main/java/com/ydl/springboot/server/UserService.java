package com.ydl.springboot.server;

import java.util.List;

import com.ydl.springboot.controller.ResMap;
import com.ydl.springboot.entity.User;
 

public interface UserService {
	public  List<User> getUsers(String name);
}
