package com.photomap.web.form;

public class PhotoForm {
	private String description;
	private String imgurl;
	private String locationName;
	private double latitude;
	private double longitude;
	private int userId;


	public String getDescription(){
		return description;
	}
	public String getImgurl(){
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
	
	public int getUserId(){
		return userId;
	}

	
	public void setDescription(String des){
		description = des;
	}
	public void setImgurl(String s){
		imgurl = s;
	}
	public void setLocationName(String lname){
		locationName = lname;
	}
	public void setLatitude(double lat){
		latitude = lat;
	}
	public void setLongitude(double lng){
		longitude = lng;
	}
	public void setUserId(int id){
		userId = id;
	}
}