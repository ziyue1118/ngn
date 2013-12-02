package com.photomap.web.dao.impl;

import com.photomap.web.dao.UserDao;
import com.photomap.web.model.User;


import javax.sql.DataSource;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

public class IUserDao implements UserDao {
	private DataSource datasource;
	private JdbcTemplate jdbctemp;
	public void save(User user1){
		String sql = "insert into Users(id, username, enabled, email, password) values (?,?,?,?,?)";
		jdbctemp.update(sql, new Object[]{user1.getId(), user1.getUsername(), 1, user1.getEmail(), user1.getPassword()});
		User newUser = findByUsername(user1.getUsername());
		String sql1 = "insert into user_roles(user_role_id, user_id, authority) values(?,?,?)";
		jdbctemp.update(sql1, new Object[]{null, newUser.getId(), "ROLE_USER"});
	}
	public void delete(String username){
		 // String sql = "select * from User where id=?";
		 // List<User> users = jdbctemp.query(sql)
		 String sql = "delete from Users where username = ?";
		 jdbctemp.update(sql, new Object[]{username});

	}
	public User findByUsername(String username){
		String sql = "select * from Users where username = ?";
		List<User> users = jdbctemp.query(sql, new Object[]{username}, new UserMapper());
		if(users.size()==0){
			return null;
		}
		else 
			return users.get(0);
	}
	public User findById(int id){
		String sql = "select * from Users where id = ?";
		List<User> users = jdbctemp.query(sql, new Object[]{id}, new UserMapper());
		if(users.size()==0){
			return null;
		}
		else 
			return users.get(0);
	}
	public void setDataSource(DataSource ds){
		this.datasource = ds;
		this.jdbctemp = new JdbcTemplate(ds);
	}

	public List<User> findall(){
		String s = "select * from Users";
		List<User> users = jdbctemp.query(s, new UserMapper());
		return users;
	}
}