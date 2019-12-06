package com.ydl.springboot.server;

import com.ydl.springboot.controller.ResMap;

public class YdlService {
	
	/**
	 * 返回请求失败的错误消息
	 * @param <T>
	 * @param resMap
	 * @param msg
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public <T> ResMap getFailureResMap(ResMap<T> resMap, String msg) {
		if (resMap == null) {
			resMap = new ResMap<T>();
		}
		resMap.setSuccess(false);
		resMap.setMsg(msg);
		return resMap;
	}
	
	/**
	 * 返回请求失败的错误消息
	 * @param resMap
	 * @param msg
	 * @param e
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public <T> ResMap getFailureResMap(ResMap<T> resMap, String msg, Exception e) {
		if (resMap == null) {
			resMap = new ResMap<T>();
		}
		resMap.setSuccess(false);
		resMap.setMsg(msg);
		return resMap;
	}
	
	/**
	 * 
	 * @param <T>
	 * @param resMap
	 * @param o
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public <T> ResMap getSuccessResMap(ResMap<T> resMap, T rules) {
		if (resMap == null) {
			resMap = new ResMap<T>();
		}
		resMap.setSuccess(true);
		resMap.setRules(rules);
		return resMap;
	}
	
	/**
	 * 返回
	 * @param resMap
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public <T> ResMap getSuccessResMap(ResMap<T> resMap) {
		return getSuccessResMap(resMap, null);
	}
}
