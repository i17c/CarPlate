package com.iver99.dao.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.iver99.dao.SobelDao;

public class SobelDaoImpl implements SobelDao {
	
	int width;// ͼ���
	int height;// ͼ���
	int[] grayData;// ͼ��Ҷ�ֵ
	int size; // ͼ���С
	int gradientThreshold = -1;// �ж�ʱ�õ�����ֵ
	BufferedImage outBinary;// ����ı�Եͼ��

	public SobelDaoImpl(int threshold) {
		gradientThreshold = threshold;
	}
	//public SobelDaoImpl(){}
	
	@Override
	public void readImage(String imageName) throws IOException {
		// TODO Auto-generated method stub
		String fileName="/usr/local/tomcat/webapps/uploadPic/"+imageName;
		File imageFile = new File(fileName);
		//File imageFile = new File("F:\\001.jpg");
		
		BufferedImage bufferedImage = ImageIO.read(imageFile);
		width = bufferedImage.getWidth();
		height = bufferedImage.getHeight();
		size = width * height;
		int imageData[] = bufferedImage.getRGB(0, 0, width, height, null, 0,
				width);// ������ͼ���RGBֵ
		outBinary = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);// ���ɱ�Եͼ��
		grayData = new int[width * height];// �����ڴ�ռ�
		for (int i = 0; i < imageData.length; i++) {
			grayData[i] = (imageData[i] & 0xff0000) >> 16;// ���ڶ����ǻҶ�ͼ����ֻ����һ��������������ֵ��ͬ��
		}
	}
	
	@Override
	public void createEdgeImage(String picName)throws Exception {
		// TODO Auto-generated method stub
		float[] gradient = gradientM();// ����ͼ������ص���ݶ�ֵ
		
		float maxGradient = gradient[0];
		
		for (int i = 1; i < gradient.length; ++i)
			if (gradient[i] > maxGradient)
				maxGradient = gradient[i];// ��ȡ�ݶ����ֵ
		float scaleFactor = 255.0f / maxGradient;// �����������ڵ����ݶȴ�С
		if (gradientThreshold >= 0) {
			for (int y = 1; y < height - 1; ++y)
				for (int x = 1; x < width - 1; ++x)
					if (Math.round(scaleFactor * gradient[y * width + x]) >= gradientThreshold)
						outBinary.setRGB(x, y, 0xffffff);// ��ɫ
		}// ���ݶȴ�С������ֵ����
		else {
			for (int y = 1; y < height - 1; ++y)
				for (int x = 1; x < width - 1; ++x)
					outBinary.setRGB(x, y, 0x000000);// ��ɫ;
		}// //�����ݶȴ�С������ֵ����, ֱ�Ӹ����ñ������ӵ������ֵ
		writeImage(outBinary, picName);
	}
	
	// �õ���(x,y)���ĻҶ�ֵ
			public int getGrayPoint(int x, int y) {
				return grayData[y * width + x];
			}

			// ���Ӽ��� ͼ��ÿ�����ص� �� �ݶȴ�С
			protected float[] gradientM() {
				float[] mag = new float[size];
				int gx, gy;
				for (int y = 1; y < height - 1; ++y)
					for (int x = 1; x < width - 1; ++x) {
						gx = GradientX(x, y);
						gy = GradientY(x, y);
						// �ù�ʽ g=|gx|+|gy|����ͼ��ÿ�����ص���ݶȴ�С.ԭ���Ǳ���ƽ���Ϳ����ķѴ���ʱ��
						mag[y * width + x] = (float) (Math.abs(gx) + Math.abs(gy));
					}
				return mag;
			}

			// ���� ���� ��(x,y)����x�����ݶȴ�С
			protected final int GradientX(int x, int y) {
				return getGrayPoint(x - 1, y - 1) + 2 * getGrayPoint(x - 1, y)
						+ getGrayPoint(x - 1, y + 1) - getGrayPoint(x + 1, y - 1) - 2
						* getGrayPoint(x + 1, y) - getGrayPoint(x + 1, y + 1);
			}// �������ص�(x,y)X�����ϵ��ݶ�ֵ
				// ���� ���� ��(x,y)����y�����ݶȴ�С

			protected final int GradientY(int x, int y) {
				return getGrayPoint(x - 1, y - 1) + 2 * getGrayPoint(x, y - 1)
						+ getGrayPoint(x + 1, y - 1) - getGrayPoint(x - 1, y + 1) - 2
						* getGrayPoint(x, y + 1) - getGrayPoint(x + 1, y + 1);
			}// �������ص�(x,y)Y�����ϵ��ݶ�ֵ

			public void writeImage(BufferedImage bi, String imageName) {
				String desFileName="/usr/local/tomcat/webapps/uploadPic/"+imageName;
				File skinImageOut = new File(desFileName);
				//File skinImageOut = new File("F:\\002.jpg");
				try {
					ImageIO.write(bi, "jpg", skinImageOut);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			public static void main(String[] args)throws Exception
			{
				SobelDaoImpl ss=new SobelDaoImpl(50);
				ss.readImage("F:\\001.jpg");
				ss.createEdgeImage("F:\\002.jpg");
			}

}
