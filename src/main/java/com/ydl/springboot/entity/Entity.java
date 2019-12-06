package com.ydl.springboot.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Entity {
	
	protected Long id;
	
	protected Date modTime;
	
	protected Timestamp inTime;
	
	protected Integer flag = 0;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getModTime() {
		return modTime;
	}

	public void setModTime(Date modTime) {
		this.modTime = modTime;
	}

	public Timestamp getInTime() {
		return inTime;
	}

	public void setInTime(Timestamp inTime) {
		this.inTime = inTime;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

}
