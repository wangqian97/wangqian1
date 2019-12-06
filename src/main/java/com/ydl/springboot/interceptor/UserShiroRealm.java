package com.ydl.springboot.interceptor;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.ydl.springboot.entity.User;
import com.ydl.springboot.server.UserService;

public class UserShiroRealm extends AuthorizingRealm {

	@Autowired
	UserService userService;
	
	/**
	 * 查询用户角色
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		List<String> roles = new ArrayList<String>();
		roles.add("admin");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRoles(roles);
		return info;
	}

	// 认证方法
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		// 验证账号密码
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		List<User> userRes = userService.getUsers(token.getUsername());
		
		if ( userRes == null || userRes.isEmpty() ) {
			return null;
		}
		User user = userRes.get(0);
		// 最后的比对需要交给安全管理器
		// 三个参数进行初步的简单认证信息对象的包装
		AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getUserPassword(),this.getClass().getSimpleName());
		return info;
	}
}
