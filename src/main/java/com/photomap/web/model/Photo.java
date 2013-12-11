package com.photomap.web.model;
import java.io.Serializable;
import java.sql.Timestamp;

public class Photo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int photoId;
	private String description;
	private String imgurl;
	private String locationName;
	private double latitude;
	private double longitude;
	private Timestamp createdTime;
	private int userId;
	private int deleted;

	public Photo(){

	}
	public int getPhotoId(){
		return photoId;
	}
	public String getDescription(){
		return description;
	}
	public String getImgUrl(){
		return imgurl;
	}
	public String getLocationName(){
		return locationName;
	}
	public double getLatitude(){
		return latitude;
	}
	public double getLongitude(){
		return longitude;
	}
	public Timestamp getCreatedTime(){
		return createdTime;
	}
	public int getUserId(){
		return userId;
	}
	public int getDeleted(){
		return deleted;
	}

	public void setPhotoId(int pid){
		photoId = pid;
	}
	public void setDescription(String des){
		description = des;
	}
	public void setImgUrl(String s){
		imgurl = s;
	}
	public void setLocationname(String lname){
		locationName = lname;
	}
	public void setLatitude(double lat){
		latitude = lat;
	}
	public void setLongitude(double lng){
		longitude = lng;
	}
	public void setCreatedTime(Timestamp t){
		createdTime = t;
	}
	public void setUserId(int id){
		userId = id;
	}
	public void setDeleted(int pDeleted){
		deleted = pDeleted;
	}

}