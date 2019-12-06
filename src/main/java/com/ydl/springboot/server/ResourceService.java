package com.ydl.springboot.server;

import java.util.List;

import com.ydl.springboot.controller.ResMap;
import com.ydl.springboot.entity.Resource;


public interface ResourceService {
	public ResMap<List<Resource>> getAll();
}
