package com.ydl.springboot.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ydl.springboot.interceptor.AdminAuthInterceptor;
import com.ydl.springboot.interceptor.IndexInterceptor;

@SuppressWarnings("deprecation")
@Configuration
public class WebYdlConfigurerAdapter   extends WebMvcConfigurerAdapter {
	  @Override
	  public void addInterceptors(InterceptorRegistry registry) {
		  registry.addInterceptor(getIndexInterceptor()).addPathPatterns("/**").excludePathPatterns("/login", "/register");
		  registry.addInterceptor(getAdminAuthInterceptor()).addPathPatterns("/admin/auth/resource/updateSave.do","/admin/auth/resource/delete.do").excludePathPatterns();
	  }
	  
	  
	  
	/**
	 * 拦截器 只有通过这样的方法才能在拦截器注入server
	 * @return
	 */
	@Bean
	public IndexInterceptor getIndexInterceptor() {
	    return new IndexInterceptor();
	}
	
	@Bean
	public AdminAuthInterceptor getAdminAuthInterceptor() {
	    return new AdminAuthInterceptor();
	}
}
