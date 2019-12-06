package com.ydl.springboot.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class IndexInterceptor extends HandlerInterceptorAdapter {
	
	/**
	 * 请求前
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
		request.setAttribute("ydl", "夜地龙博客欢迎您");
		return true;
    }

	/**
	 * 请求结束 视图渲染之前
	 */
	@Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)throws Exception {
		System.out.println("完成");
	}

	/**
	 * 视图渲染之后
	 */
	@Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)throws Exception {
	}
}
