package com.iver99.biz;

import org.springframework.web.multipart.MultipartFile;

public interface UploadPictureService {
	
	public boolean uploadPictureService(MultipartFile file,String picName)throws Exception;

}
