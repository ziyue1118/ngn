package com.photomap.web.dao.impl;

import com.photomap.web.dao.UserDao;
import com.photomap.web.model.User;


import javax.sql.DataSource;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

public class IUserDao implements UserDao {
	private DataSource datasource;
	private JdbcTemplate jdbctemp;

	public void setDataSource(DataSource ds){
		this.datasource = ds;
		this.jdbctemp = new JdbcTemplate(ds);
	}

	public List<User> findall(){
		String s = "select * from User";
		List<User> users = jdbctemp.query(s, new UserMapper());
		return users;
	}
}