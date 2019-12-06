package com.ydl.springboot.conf;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ydl.springboot.controller.ResMap;
import com.ydl.springboot.entity.Resource;
import com.ydl.springboot.interceptor.UserShiroRealm;
import com.ydl.springboot.server.ResourceService;
import com.ydl.springboot.util.StringUtil;

import org.apache.shiro.mgt.SecurityManager;

@Configuration
public class ShiroConfig {

	@Autowired
	private ResourceService resourceService;
	
    /**
     * 凭证匹配器
     *
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //md5加密1次
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(1);
        return hashedCredentialsMatcher;
    }

    /**
     * 自定义realm
     *
     * @return
     */
    @Bean
    public UserShiroRealm userRealm() {
    	UserShiroRealm userRealm = new UserShiroRealm();
        userRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return userRealm;
    }

    /**
     * 安全管理器
     * 注：使用shiro-spring-boot-starter 1.4时，返回类型是SecurityManager会报错，直接引用shiro-spring则不报错
     *
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());
        return securityManager;
    }


    /**
     * 设置过滤规则
     *
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
    	System.out.println(resourceService+"resourceService");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/admin/index.do");
        shiroFilterFactoryBean.setSuccessUrl("/admin/post/index.do");
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauth");

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
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }
}
