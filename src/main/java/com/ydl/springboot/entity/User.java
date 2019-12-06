package com.ydl.springboot.entity;

import java.sql.Timestamp;
import java.util.Date;


public class User {

	private Long id;

	private Date modTime;

	private Timestamp inTime;

	private Integer flag = 0;

	/**
	 * 用户唯一ID
	 */
	private String userNo;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 用户邮箱
	 */
	private String mailbox;

	/**
	 * 用户登录密码
	 */
	private String userPassword;

	/**
	 * 头像
	 */
	private String avatar;

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMailbox() {
		return mailbox;
	}

	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

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
