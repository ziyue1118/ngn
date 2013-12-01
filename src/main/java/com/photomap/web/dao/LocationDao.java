package com.photomap.web.dao;

import com.photomap.web.model.Location;
import java.util.List;
import javax.sql.DataSource;

public interface LocationDao {
	public void save(Location local);
	public Location findById(int lid);
	public Location findByLocationname(String lname);
	public List<Location> findall();
	public void setDataSource(DataSource ds);
}