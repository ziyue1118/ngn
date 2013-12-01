package com.photomap.web.dao.impl;

import com.photomap.web.dao.LocationDao;
import com.photomap.web.model.Location;

import javax.sql.DataSource;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;


public class ILocationDao implements LocationDao {
	private DataSource datasource;
	private JdbcTemplate jdbctemp;
	public void save(Location local){
		String sql = "insert into Locations(lid, lname, lat, lng) values(?,?,?,?)";
		jdbctemp.update(sql, new Object[]{local.getLocationId(),local.getLocationName(),local.getLatitude(), local.getLongitude()});		
	}
	public Location findById(int lid){
		String sql = "select * from Locations where lid = ?";
		List<Location> locations = jdbctemp.query(sql, new Object[]{lid}, new LocationMapper());
		if(locations.size()==0){
			return null;
		}
		else {
			return locations.get(0);
		}
	}
	public Location findByLocationname(String lname){
		String sql = "select * from Locations where lname = ?";
		List<Location>locations = jdbctemp.query(sql, new Object[]{lname}, new LocationMapper());
		if(locations.size()==0){
			return null;
		}
		else {
			return locations.get(0);
		}
	}
	public List<Location> findall(){
		String s = "select * from Locations";
		List<Location> locations = jdbctemp.query(s,new LocationMapper());
		return locations;
	}
	public void setDataSource(DataSource ds){
		this.datasource = ds;
		this.jdbctemp = new JdbcTemplate(ds);
	}

}