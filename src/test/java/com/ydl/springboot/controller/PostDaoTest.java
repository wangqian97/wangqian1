package com.ydl.springboot.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ydl.springboot.SpringBootStart;
import com.ydl.springboot.dao.UserDao;

@RunWith(SpringRunner.class) //指定当前运行环境s
@SpringBootTest(classes = SpringBootStart.class)  //指定当前类是一个测试类
@MapperScan("com.ydl.springboot.dao")
public class PostDaoTest {
	@Autowired 
	UserDao postDao;
 
	@Test
	public void test() {
	//postDao.getUsers(>());
	}

}
