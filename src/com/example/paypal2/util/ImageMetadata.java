package com.example.paypal2.util;

import java.util.HashMap;

/**
 * This is a singleton class, it capture all the image informations
 * 
 * @author Shilpa Bambore
 */
public class ImageMetadata {

	public static ImageMetadata INSTANCE = new ImageMetadata();
	HashMap<String, ImageInformation> details = new HashMap<String, ImageInformation>(); 
	private ImageMetadata(){
	}
	
	public static ImageMetadata getInstance(){
		return INSTANCE;
	}
	
	public void addImageMetadata(String key, ImageInformation info){
		details.put(key, info);
	}
	
	public ImageInformation getImageDetails(String key){
		return details.get(key);
	}
}
