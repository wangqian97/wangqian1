package com.ydl.springboot.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PropertiesUtil {
	
	public static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);
	private static final String fileName = "applicationContext.properties";
	
	/**
	 * 根据文件路径返回 Properties
	 * @param filePath
	 * @return
	 */
	public static Properties getProperties(String filePath) throws FileNotFoundException {
		Properties properties = new Properties();
		InputStream is = null;
		filePath = StringUtil.trim(filePath);
		File file = new File(filePath);
		if (!file.exists()) {
			throw new FileNotFoundException(" file " + filePath + " not exists!");
		}
		is = new FileInputStream(file);
		try {
			properties.load(is);
			is.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return properties;
	}
	
	/**
	 * 现在classes下面找配置文件，如果没有则去tomcat下的blog 里面找
	 * @return
	 */
	public static Properties  getPropertiesConf(String fileName) throws FileNotFoundException {
		//得到classes下的 文件绝对路径
		String realPath = PropertiesUtil.class.getResource("/").getPath() + File.separator + "conf" + File.separator + fileName;
		File file = new File(realPath);
		if (!file.exists()) {
			//得到tomcat下的 文件绝对路径
			realPath = System.getProperty("catalina.home") + File.separator + "blog" + File.separator + fileName;
			logger.info(" file " + fileName + " path is" + realPath);
			file = new File(realPath);
			if (!file.exists()) {
				throw new FileNotFoundException(" file " + fileName + " not exists!");
			}
		}
		logger.info(" file " + fileName + " path is" + realPath);
		return getProperties(realPath);
	}
	
	public static String getValue(String key) throws FileNotFoundException {
		return (String) getPropertiesConf(fileName).get(key);
	}
}
