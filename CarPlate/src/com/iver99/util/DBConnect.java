package com.iver99.util;

import java.sql.*;

public class DBConnect {
	
	public static Connection conn;
	/**
	 * �������ݿ�����
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
			System.out.println("DBConnect�����ݿ����Ӵ���");
			e.printStackTrace();
		}
		/*�ϴ��������˴�Ӧ�޸�*/
		
		
	
				
		return conn;
	}
	/**
	 * �ر����ݿ�����
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
			System.out.println("�ر����ݿ����");
			e.printStackTrace();
		}
	}

}
