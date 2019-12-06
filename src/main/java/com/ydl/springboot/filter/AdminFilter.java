package com.ydl.springboot.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;



@WebFilter(filterName="adminFilter",urlPatterns={"/*"})
@Order(value=1)
public class AdminFilter implements Filter {

	public static Logger logger = LoggerFactory.getLogger(AdminFilter.class);
	 
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		//销毁过滤器
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse rep, FilterChain arg2)
			throws IOException, ServletException {
		 System.out.println("你正经过一个过滤器");
		 arg2.doFilter(req, rep);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
	}

}
