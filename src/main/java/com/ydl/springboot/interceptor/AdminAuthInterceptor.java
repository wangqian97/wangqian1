package com.ydl.springboot.interceptor;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ydl.springboot.controller.ResMap;
import com.ydl.springboot.entity.Resource;
import com.ydl.springboot.server.ResourceService;
import com.ydl.springboot.util.StringUtil;

@Component
public class AdminAuthInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	private ShiroFilterFactoryBean shiroFilterFactoryBean;
	
	@Autowired
	private ResourceService resourceService;
	
	
	/**
	 * 每次对权限相关的操作 就更新权限链
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        ResMap<List<Resource>>  resMap = resourceService.getAll();
        if (resMap.isSuccess()) {
        	for (Resource item : resMap.getRules()) {
        		if (!StringUtil.isEmpty(item.getRuri())) {
        			filterChainDefinitionMap.put("/" + item.getRuri(), "authc");
        		}
        	}
        	filterChainDefinitionMap.put("/**", "anon");
        } else {
        	filterChainDefinitionMap.put("/**", "authc");
        }
        AbstractShiroFilter shiroFilter = (AbstractShiroFilter) shiroFilterFactoryBean.getObject();
        PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver) shiroFilter
                .getFilterChainResolver();
        DefaultFilterChainManager filterManager = (DefaultFilterChainManager) filterChainResolver.getFilterChainManager();
        //清空拦截管理器中的存储
        filterManager.getFilterChains().clear();
		return true;
    }
	
	
}
