package DataBaseConnection.DTO;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataBaseConnection {
	
	static Connection conn;

	String mariaDB = "org.mariadb.jdbc.Driver";
//	String mysql = "com.mysql.jdbc.Driver";
	String mysql = "com.mysql.cj.jdbc.Driver";

	private String driver = mariaDB;
	
//	private String ip = "localhost"; 
	private String ip = "mariadb-kms.mariadb.database.azure.com"; 
	private String port = "3306";
	private String databaseName = "CORONA";
	
	private String dataBaseUrl 	= "jdbc:mysql://"+ip+":"+port+"/"+databaseName+"?serverTimezone=UTC";
	private String dataBaseId 	= "master";
	private String dataBasePw 	= "megazone!234";
	
	/*Local IP*/
	public String getServerIP() {
		InetAddress local = null;
		try {
			local = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		if(local == null) {
			return "";
		}else {
			String ip = local.getHostAddress();
			return ip;
		}
	}
	
	/*DB Driver*/
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	
	
	/*Server IP, Port*/
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	
	/*DB 접속 정보*/
	public String getDataBaseUrl() {
		return dataBaseUrl;
	}
	public void setDataBaseUrl(String dataBaseUrl) {
		this.dataBaseUrl = dataBaseUrl;
	}
	public String getDataBaseId() {
		return dataBaseId;
	}
	public void setDataBaseId(String dataBaseId) {
		this.dataBaseId = dataBaseId;
	}
	public String getDataBasePw() {
		return "***************";
	}
	public void setDataBasePw(String dataBasePw) {
		this.dataBasePw = dataBasePw;
	}
	
	public Connection dataBaseConnection() {
		try {
			Class.forName(driver);
			this.conn = DriverManager.getConnection(dataBaseUrl, dataBaseId, dataBasePw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.conn;
	}//The end of Constructor
	

}//The end of Method
