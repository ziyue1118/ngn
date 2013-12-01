package com.photomap.web.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.photomap.web.model.Photo;

public class PhotoMapper implements RowMapper<Photo> {
	public Photo mapRow(ResultSet rs, int rowNum) throws SQLException {
		Photo p = new Photo();
		p.setPhotoId(rs.getInt("pid"));
		p.setDescription(rs.getString("description"));
		p.setImgUrl(rs.getString("imgurl"));
		p.setLocationname(rs.getString("lname"));
		p.setLatitude(rs.getDouble("lat"));
		p.setLongitude(rs.getDouble("lng"));
		p.setCreatedTime(rs.getTimestamp("createtime"));
		p.setUserId(rs.getInt("id"));
		return p;
	}
}