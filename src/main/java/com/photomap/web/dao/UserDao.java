package com.photomap.web.dao;

import com.photomap.web.model.User;
import java.util.List;
import javax.sql.DataSource;

public interface UserDao {
	List<User> findall();
	void setDataSource(DataSource ds);
}