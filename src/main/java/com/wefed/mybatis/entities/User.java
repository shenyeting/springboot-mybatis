package com.wefed.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

/**
 * The persistent class for the t_user database table.
 * 
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private String password;

	private String remark;

	private String userName;

	private Date birthday;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", remark=" + remark + ", userName=" + userName
				+ ", birthday=" + birthday + "]";
	}

}