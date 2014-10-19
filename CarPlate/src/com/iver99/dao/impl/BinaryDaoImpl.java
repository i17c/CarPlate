package com.iver99.dao.impl;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.iver99.dao.BinaryDao;

public class BinaryDaoImpl implements BinaryDao{

	@Override
	public String binaryImage(String picName)throws Exception {
		// TODO Auto-generated method stub
		String fileName="/usr/local/tomcat/webapps/uploadPic/"+picName;
		//String fileName="D:\\usr\\local\\tomcat\\webapps\\upload"+"\\"+pictureName;
		System.out.println("二值化处图片位置");
		File file = new File(fileName);
		BufferedImage image = ImageIO.read(file);

		int width = image.getWidth();
		int height = image.getHeight();

		BufferedImage grayImage = new BufferedImage(width, height,
				BufferedImage.TYPE_BYTE_BINARY);// 重点，技巧在这个参数BufferedImage.TYPE_BYTE_BINARY
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int rgb = image.getRGB(i, j);
				grayImage.setRGB(i, j, rgb);
			}
		}
		String name=System.currentTimeMillis()+"";
		String newFileName="/usr/local/tomcat/webapps/uploadPic/"+name+".jpg";
		//String newFileName="D:\\usr\\local\\tomcat\\webapps\\upload"+"\\"+name;
		File newFile = new File(newFileName);
		ImageIO.write(grayImage,"jpg", newFile);
		return name;//返回不带后缀的文件名
		
		
	}

}
