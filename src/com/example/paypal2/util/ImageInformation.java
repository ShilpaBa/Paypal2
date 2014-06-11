package com.example.paypal2.util;

/**
 * This bean class stores image information.
 * @author Shilpa Bambore
 *
 */
public class ImageInformation {

	private String location = null;
	private String name = null;
	private String currentDate = null;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
