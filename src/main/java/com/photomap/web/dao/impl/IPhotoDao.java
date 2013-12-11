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
		String sql = "insert into Photos(description, imgurl, lname, lat, lng, id, deleted) values(?,?,?,?,?,?,?)";
		jdbctemp.update(sql, new Object[]{p.getDescription(),p.getImgUrl(),p.getLocationName(), p.getLatitude(), p.getLongitude(), p.getUserId(), p.getDeleted()});		
	}
	public List<Photo> findallbyUserId(int userid){
		String sql = "select * from Photos where id = ? and deleted = 0";
		List<Photo> photos =  jdbctemp.query(sql, new Object[]{userid}, new PhotoMapper());
		return photos;
	}
	public List<Photo> findallPhotos(){
		String sql = "select * from Photos where deleted = 0";
		List<Photo> photos = jdbctemp.query(sql, new PhotoMapper());
		return photos;
	}
	public List<Photo> findallLatestPhotos(){
		String sql = "select * from Photos where deleted = 0 order by createtime DESC";
		List<Photo> photos = jdbctemp.query(sql, new PhotoMapper());
		return photos;
	}
	public void deletePhoto(int pPhotoId){
		String sql = "update Photos set deleted = 1 where pid = ?";
		jdbctemp.update(sql, new Object[]{pPhotoId});
		return;
	}
	
	public List<Photo> findbyLocation(double lat, double lng){
		String sql = "select * from Photos where lat = ? and lng = ? order by createtime DESC";
		List<Photo> photos = jdbctemp.query(sql, new Object[]{lat, lng}, new PhotoMapper());
		return photos;
	}

	public void setDataSource(DataSource ds){
		this.datasource = ds;
		this.jdbctemp = new JdbcTemplate(ds);
	}

}