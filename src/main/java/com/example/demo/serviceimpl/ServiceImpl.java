package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.Dao;
import com.example.demo.model.Message;
import com.example.demo.model.Users;
import com.example.demo.service.Service;

@Repository
public class ServiceImpl implements Service {

	@Autowired
	Dao dao;

	@Override
	public int registerUser(Users user) {
		return dao.registerUser(user);
	}

	@Override
	public List<String> messages(Users user) {
		return dao.messages(user);
	}

	@Override
	public void messageSeen(Users user, Message msg) {
		dao.messageSeen(user, msg);
	}

	@Override
	public void sendMessage(Users user1, Users user2, String msg) {
		dao.sendMessage(user1, user2, msg);
	}

}
