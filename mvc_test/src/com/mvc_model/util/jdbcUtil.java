package com.mvc_model.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class jdbcUtil {
	private static String driver = "";
	private static String url = "";
	private static  String user = "";
	private static  String password = "";
	public static void init() throws IOException, ClassNotFoundException{
		InputStream is = jdbcUtil.class.getClassLoader().getResourceAsStream("db.properties");
		Properties pro = new Properties();
		pro.load(is);
		driver = (String)pro.getProperty("driver");
		url = (String)pro.getProperty("url");
		user = (String)pro.getProperty("user");
		password = (String)pro.getProperty("password");
		is.close();
		Class.forName(driver);
	}
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, user, password);
	}
	
	public static void release(Connection conn,Statement st, ResultSet rs) throws SQLException{
		if(conn!=null){
			conn.close();
		}
		if(rs!=null){
			rs.close();
		}
		if(st!=null){
			st.close();
		}
	}
}
