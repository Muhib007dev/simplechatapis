package com.example.demo.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.Dao;
import com.example.demo.model.Message;
import com.example.demo.model.Users;

@Repository
public class DaoImpl extends JdbcDaoSupport implements Dao {

	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemp;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
		System.out.println("testing...................");
		try {
			getJdbcTemplate().execute(
					"CREATE TABLE users (user_id int NOT NULL PRIMARY KEY AUTO_INCREMENT ,nickname varchar(25) NOT NULL UNIQUE)");
			getJdbcTemplate().execute(
					"CREATE TABLE   message (m_id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,user_one int(11) NOT NULL,user_two int(11) NOT NULL,message VARCHAR(200),seen BOOLEAN DEFAULT FALSE,FOREIGN KEY (user_one) REFERENCES users(user_id),FOREIGN KEY (user_two) REFERENCES users(user_id))");
			getJdbcTemplate().execute("insert into users(nickname) values('testing')");
			getJdbcTemplate().execute("insert into users(nickname) values('testing123')");
			getJdbcTemplate().execute("insert into users(nickname) values('testing456')");
			getJdbcTemplate().execute("insert into users(nickname) values('testing789')");
			getJdbcTemplate().execute("insert into message(user_one,user_two,message) values(1,2,'hello')");
			getJdbcTemplate().execute("insert into message(user_one,user_two,message) values(2,1,'hii')");
			getJdbcTemplate().execute("insert into message(user_one,user_two,message) values(1,2,'how are you')");
			getJdbcTemplate().execute("insert into message(user_one,user_two,message,seen) values(2,1,'I am good',true)");			
		} catch (Exception exp) {
			
		}

	}

	@Override
	public int registerUser(Users user) {
		String sql = "INSERT INTO users (nickname) VALUES (?)";
		getJdbcTemplate().update(sql, new Object[] { user.getNickName() });
		String sql2 = "SELECT * FROM users WHERE nickname = '" + user.getNickName() + "'";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql2);
		int userIdentifier = -1;
		for (Map<String, Object> row : rows) {
			userIdentifier = (int) row.get("user_id");
		}
		return userIdentifier;
	}

	@Override
	public List<String> messages(Users user) {
		String sql = "SELECT * FROM message WHERE user_one =" + user.getUser_id() + " && seen = 0";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		List<String> result = new ArrayList<String>();
		for (Map<String, Object> row : rows) {
			result.add((String) row.get("message"));
		}
		return result;
	}

	@Override
	public void messageSeen(Users user, Message msg) {
		String sql = "update message set seen = true where m_id =" + msg.getM_id() + " && user_two = "
				+ user.getUser_id();
		getJdbcTemplate().update(sql);
	}

	@Override
	public void sendMessage(Users user1, Users user2, String msg) {
		String sql = "insert into message (user_one,user_two,message) values(" + user1.getUser_id() + ","
				+ user2.getUser_id() + ",'" + msg + "')";
		getJdbcTemplate().update(sql);
	}

}
