package com.iver99.dao;

public interface SobelDao {

	//public String sobelImage(String picName)throws Exception;
	
	public void readImage(String picName)throws Exception;
	
	public void createEdgeImage(String newPicName)throws Exception;
	
}
