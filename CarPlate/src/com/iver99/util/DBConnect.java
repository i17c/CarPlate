package com.iver99.util;

import java.sql.*;

public class DBConnect {
	
	public static Connection conn;
	/**
	 * 建立数据库连接
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection()
	{
		String url="jdbc:mysql://127.0.0.1:3306/car";
		String username="root";
		String password="123456";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("DBConnect类数据库连接错误");
			e.printStackTrace();
		}
		/*上传服务器此处应修改*/
		
		
	
				
		return conn;
	}
	/**
	 * 关闭数据库连接
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public static void closeConnection(Connection conn,Statement stmt,ResultSet rs)
	{
		try{
			if(conn!=null)
				conn.close();
			if(stmt!=null)
				stmt.close();
			if(rs!=null)
				rs.close();
			
		}catch(SQLException e)
		{
			System.out.println("关闭数据库出错！");
			e.printStackTrace();
		}
	}

}
