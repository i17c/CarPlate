package com.iver99.dao;

import org.springframework.web.multipart.MultipartFile;

public interface UploadPictureDao {
	
	public boolean uploadPicture(MultipartFile file,String picName)throws Exception;

}
