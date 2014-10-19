package com.iver99.dao.impl;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.iver99.dao.GrayDao;

public class GrayDaoImpl implements GrayDao {

	@Override
	public String grayImage(String picName)throws Exception {
		// TODO Auto-generated method stub
		String fileName="/usr/local/tomcat/webapps/uploadPic/"+picName;
		File file = new File(fileName);
		BufferedImage image = ImageIO.read(file);

		int width = image.getWidth();
		int height = image.getHeight();

		BufferedImage grayImage = new BufferedImage(width, height,
				BufferedImage.TYPE_BYTE_GRAY);// 重点，技巧在这个参数BufferedImage.TYPE_BYTE_GRAY
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int rgb = image.getRGB(i, j);
				grayImage.setRGB(i, j, rgb);
			}
		}
		String name=System.currentTimeMillis()+"";
		String newFileName="/usr/local/tomcat/webapps/uploadPic/"+name+".jpg";
		
		File newFile = new File(newFileName);
		ImageIO.write(grayImage, "jpg", newFile);
		return name;
		//返回不带后缀的文件名
	}

}
