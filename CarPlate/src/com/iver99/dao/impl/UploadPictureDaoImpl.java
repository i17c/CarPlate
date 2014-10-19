package com.iver99.dao.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.iver99.dao.UploadPictureDao;
import com.iver99.util.ApplicationContextFactory;
import com.iver99.vo.LicensePlateInfo;

public class UploadPictureDaoImpl implements UploadPictureDao {

	@Override
	public boolean uploadPicture(MultipartFile file,String picName)throws Exception {
		// TODO Auto-generated method stub
		 System.out.println("fileName(Dao)--->"+picName);
		 try {  
			// File ff=new File("aabc");
			// ff.mkdir();
			 //test
             FileOutputStream os = new FileOutputStream("/usr/local/tomcat/webapps/uploadPic"+"//"+picName);  
             InputStream in = file.getInputStream();  
             int b=0;  
             while((b=in.read())!=-1){  
                 os.write(b);  
             }  
             os.flush();  
             os.close();  
             in.close();  
         } catch (FileNotFoundException e) {  
             // TODO Auto-generated catch block  
             e.printStackTrace();  
         } 
		/*存储图片名称到数据库*/
		 ApplicationContext ac=ApplicationContextFactory.getApplicationContext();
		 HibernateTemplate hibTemplate=new HibernateTemplate((SessionFactory)(ac.getBean("sessionFactory")));
		 LicensePlateInfo licensePlateInfo=(LicensePlateInfo)(ac.getBean("licensePlateInfo"));
		 licensePlateInfo.setPicture(picName);
		 
		 hibTemplate.save(licensePlateInfo);
		 
		return true;
	}

}
