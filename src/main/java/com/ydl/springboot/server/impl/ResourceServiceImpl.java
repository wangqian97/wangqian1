package com.ydl.springboot.server.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ydl.springboot.controller.ResMap;
import com.ydl.springboot.dao.ResourceDao;
import com.ydl.springboot.entity.Resource;
import com.ydl.springboot.server.ResourceService;
import com.ydl.springboot.server.YdlService;

@Service
public class ResourceServiceImpl extends YdlService implements ResourceService {
	
	public static Logger logger = LoggerFactory.getLogger(ResourceServiceImpl.class);

	@Autowired 
	ResourceDao resourceDao;
	
	 
	@SuppressWarnings("unchecked")
	@Override
	public ResMap<List<Resource>> getAll() {
		ResMap<List<Resource>> resMap = new ResMap<List<Resource>>();
		try {
			List<Resource> relist = resourceDao.getAll();
			resMap = getSuccessResMap(resMap, relist);
		} catch (Exception e) {
			logger.error("查询资源失败",e);
			resMap = getFailureResMap(resMap, "查询资源失败");
		}
		return resMap;
	}
}
