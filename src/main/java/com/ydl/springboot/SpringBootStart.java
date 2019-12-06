package com.ydl.springboot;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.ydl.springboot.dao")
@ServletComponentScan(basePackages = {"com.ydl.springboot"})
public class SpringBootStart {
    public static void main( String[] args )  {
    	SpringApplication.run(SpringBootStart.class);
    }
}