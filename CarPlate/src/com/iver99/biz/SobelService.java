package com.iver99.biz;

public interface SobelService {

	//public String SobelService(String picName)throws Exception;
	
	public void readImage(String picName)throws Exception;
	
	public void createEdgeImage(String newPicName)throws Exception;
}
