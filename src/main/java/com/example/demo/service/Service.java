package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Message;
import com.example.demo.model.Users;

public interface Service {
	int registerUser(Users user);

	List<String> messages(Users user);

	void messageSeen(Users user, Message msg);

	void sendMessage(Users user1, Users user2, String msg);
}
