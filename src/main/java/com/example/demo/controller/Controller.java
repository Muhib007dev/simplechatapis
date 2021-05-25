package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Message;
import com.example.demo.model.Users;
import com.example.demo.service.Service;

@RestController
public class Controller {
	@Autowired
	Service service;

	@RequestMapping("registeruser")
	int uniqueId(@RequestParam String name) {
		Users user = new Users();
		user.setNickName(name);
		return service.registerUser(user);
	}

	@RequestMapping("messages")
	List<String> messages(@RequestParam int useridentifier) {
		Users user = new Users();
		user.setUser_id(useridentifier);
		return service.messages(user);
	}

	@RequestMapping("messageseen")
	void messageSeen(@RequestParam int useridentifier, @RequestParam int msgidentifier) {
		Users user = new Users();
		Message msg = new Message();
		user.setUser_id(useridentifier);
		msg.setM_id(msgidentifier);
		service.messageSeen(user, msg);
	}

	@RequestMapping("sendmessage")
	void sendMessage(@RequestParam int useridentifier1, @RequestParam int useridentifier2, @RequestParam String msg) {
		Users user1 = new Users();
		Users user2 = new Users();
		user1.setUser_id(useridentifier1);
		user2.setUser_id(useridentifier2);
		service.sendMessage(user1, user2, msg);
	}
}
