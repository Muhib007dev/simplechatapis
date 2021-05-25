package com.example.demo.model;

public class Users {
	private int user_id;
	private String nickName;

	public Users() {
		// TODO Auto-generated constructor stub
	}

	public Users(String nickName) {
		super();
		this.nickName = nickName;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", nickName=" + nickName + "]";
	}

}
