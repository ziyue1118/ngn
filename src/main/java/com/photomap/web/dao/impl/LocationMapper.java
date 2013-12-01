package com.photomap.web.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.photomap.web.model.Location;

public class LocationMapper implements RowMapper<Location> {
	public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
		Location local = new Location();
		local.setLocationId(rs.getInt("lid"));
		local.setLocationname(rs.getString("lname"));
		local.setLatitude(rs.getDouble("lat"));
		local.setLongitude(rs.getDouble("lng"));
		return local;
	}
}