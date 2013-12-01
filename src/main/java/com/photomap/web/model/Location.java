package com.photomap.web.model;
import java.io.Serializable;

public class Location implements Serializable {
	private static final long serialVersionUID = 1L;
	private int locationId;
	private String locationName;
	private double latitude;
	private double longitude;

	public Location(){

	}
	public Location(int lid, String lname, double lat, double lng){
		locationId = lid;
		locationName = lname;
		latitude = lat;
		longitude = lng;
	}
	public int getLocationId(){
		return locationId;
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
	public void setLocationId(int lid){
		locationId = lid;
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

}