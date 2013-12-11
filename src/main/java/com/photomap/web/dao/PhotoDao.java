package com.photomap.web.dao;

import com.photomap.web.model.Photo;
import java.util.List;
import javax.sql.DataSource;

public interface PhotoDao {
	public void save(Photo p);
	public List<Photo> findallbyUserId(int userid);
	public List<Photo> findallPhotos();
	public List<Photo> findallLatestPhotos();
	public List<Photo> findbyLocation(double lat, double lng);
	public void deletePhoto(int pPhotoId);
	public void setDataSource(DataSource ds);
}