package com.photomap.web.dao.impl;

import com.photomap.web.dao.PhotoDao;
import com.photomap.web.model.Photo;

import javax.sql.DataSource;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;


public class IPhotoDao implements PhotoDao {
	private DataSource datasource;
	private JdbcTemplate jdbctemp;
	public void save(Photo p){
		String sql = "insert into Photos(description, imgurl, lname, lat, lng, id) values(?,?,?,?,?,?)";
		jdbctemp.update(sql, new Object[]{p.getDescription(),p.getImgUrl(),p.getLocationName(), p.getLatitude(), p.getLongitude(), p.getUserId()});		
	}
	public List<Photo> findallbyUserId(int userid){
		String sql = "select * from Photos where id = ?";
		List<Photo> photos =  jdbctemp.query(sql, new Object[]{userid}, new PhotoMapper());
		return photos;
	}
	public List<Photo> findallPhotos(){
		String sql = "select * from Photos";
		List<Photo> photos = jdbctemp.query(sql, new PhotoMapper());
		return photos;
	}
	public List<Photo> findallLatestPhotos(){
		String sql = "select * from Photos order by createtime DESC";
		List<Photo> photos = jdbctemp.query(sql, new PhotoMapper());
		return photos;
	}

	public void setDataSource(DataSource ds){
		this.datasource = ds;
		this.jdbctemp = new JdbcTemplate(ds);
	}

}