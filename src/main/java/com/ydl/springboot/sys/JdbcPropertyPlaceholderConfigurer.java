package com.ydl.springboot.sys;

import java.io.FileNotFoundException;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.ydl.springboot.util.PropertiesUtil;


public class JdbcPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
  
	/**
	 * 修改jdbc获取的配置文件
	 */
	@Override  
    protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props) throws BeansException {  
        try {
        	
        	Properties pp = PropertiesUtil.getPropertiesConf("jdbc.properties");
			super.processProperties(beanFactory, pp);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    }  
    
}
