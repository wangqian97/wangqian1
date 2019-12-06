package com.ydl.springboot.entity;

import java.util.List;

/**
 * 资源路径
 * @author huangjie
 *
 */
public class Resource extends Entity {
	
	private Long fatherId; // 父类资源id
	
	private String ruri; // 请求路径
	
	private String ricon; // ico
	
	private String rname; // 名称
	
	private Integer rtype;// 1 是ajax请求   0 不是
	
	
	private List<Resource> sonList;
	
	
	private Resource fatherResource;


	public Long getFatherId() {
		return fatherId;
	}


	public void setFatherId(Long fatherId) {
		this.fatherId = fatherId;
	}


	public String getRuri() {
		return ruri;
	}


	public void setRuri(String ruri) {
		this.ruri = ruri;
	}


	public String getRicon() {
		return ricon;
	}


	public void setRicon(String ricon) {
		this.ricon = ricon;
	}


	public String getRname() {
		return rname;
	}


	public void setRname(String rname) {
		this.rname = rname;
	}


	public Integer getRtype() {
		return rtype;
	}


	public void setRtype(Integer rtype) {
		this.rtype = rtype;
	}


	public List<Resource> getSonList() {
		return sonList;
	}


	public void setSonList(List<Resource> sonList) {
		this.sonList = sonList;
	}


	public Resource getFatherResource() {
		return fatherResource;
	}


	public void setFatherResource(Resource fatherResource) {
		this.fatherResource = fatherResource;
	}
	
 

	 
}
