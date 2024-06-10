package com.edubridge.fanapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FanUtil {


public static Connection getConnection() {
	Connection con = null;
	String driver,url,user,password;
	driver="com.mysql.cj.jdbc.Driver";
	url="jdbc:mysql://localhost:3306/sathwika";
	user="root";
	password="root";
	
	try {
		Class.forName(driver);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		 con = DriverManager.getConnection(url,user,password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
}
}
