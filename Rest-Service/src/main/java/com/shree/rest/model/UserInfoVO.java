package com.shree.rest.model;

public class UserInfoVO {
	private int id;
	private String userName;
	private String address;

	public UserInfoVO(int id, String userName, String address) {
		super();
		this.id = id;
		this.userName = userName;
		this.address = address;
	}

	public UserInfoVO() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", userName=" + userName + ", address=" + address + "]";
	}

}
