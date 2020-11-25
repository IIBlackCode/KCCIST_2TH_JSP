package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataBaseConnection {
	
	int a = 10;
	static Connection conn;

	public DataBaseConnection() {
		try {
			String mariaDB = "org.mariadb.jdbc.Driver";
//			String mysql = "com.mysql.jdbc.Driver";
			String mysql = "com.mysql.cj.jdbc.Driver";

			String dataBaseUrl = "jdbc:mysql://localhost:3306/corona?serverTimezone=UTC";
			String dataBaseId = "root";
			String dataBasePw = "1234";

			Class.forName(mysql);
			this.conn = DriverManager.getConnection(dataBaseUrl, dataBaseId, dataBasePw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//The end of Constructor

}//The end of Method
