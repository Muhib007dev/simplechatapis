package com.example.demo.model;

public class Message {
	private int m_id;
	private int user_one;
	private int user_two;
	private String message;
	private boolean seen;

	public Message() {
		// TODO Auto-generated constructor stub
	}

	public Message(int user_one, int user_two, String message, boolean seen) {
		super();
		this.user_one = user_one;
		this.user_two = user_two;
		this.message = message;
		this.seen = seen;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	
	public int getM_id() {
		return m_id;
	}

	public int getUser_one() {
		return user_one;
	}

	public void setUser_one(int user_one) {
		this.user_one = user_one;
	}

	public int getUser_two() {
		return user_two;
	}

	public void setUser_two(int user_two) {
		this.user_two = user_two;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSeen() {
		return seen;
	}

	public void setSeen(boolean seen) {
		this.seen = seen;
	}

	@Override
	public String toString() {
		return "Message [m_id=" + m_id + ", user_one=" + user_one + ", user_two=" + user_two + ", message=" + message
				+ ", seen=" + seen + "]";
	}

}
