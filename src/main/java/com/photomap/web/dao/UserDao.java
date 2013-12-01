package com.photomap.web.dao;

import com.photomap.web.model.User;
import java.util.List;
import javax.sql.DataSource;

public interface UserDao {
	public void save(User user1);
	public void delete(String username);
	public User findByUsername(String username);
	public User findById(int id);
	public List<User> findall();
	public void setDataSource(DataSource ds);
}