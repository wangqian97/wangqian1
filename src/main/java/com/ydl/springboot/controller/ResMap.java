package com.ydl.springboot.controller;

/**
 * 用于返回数据
 * @author 14991
 *
 */
public class ResMap<T> {
	
	private boolean isSuccess;
	/**
	 * 时间
	 */
	private String time = "";
	
	/**
	 * 本次信息id
	 */
	private String  rsid  = "";
	
	/**
	 * 请求码
	 */
	private String   code  = "";
	
	/**
	 * 内容
	 */
	private String   msg = "";
	
	/**
	 * 异常体信息
	 */
	private Exception exception;
	
	private T  rules;
 
	public ResMap(){
		
	}
	
	public T getRules() {
		return rules;
	}

	public void setRules(T rules) {
		this.rules = rules;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getRsid() {
		return rsid;
	}

	public void setRsid(String rsid) {
		this.rsid = rsid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}
}
