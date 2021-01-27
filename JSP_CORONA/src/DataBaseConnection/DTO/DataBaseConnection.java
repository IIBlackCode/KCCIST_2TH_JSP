package DataBaseConnection.DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataBaseConnection {
	
	static Connection conn;

	String mariaDB = "org.mariadb.jdbc.Driver";
//	String mysql = "com.mysql.jdbc.Driver";
	String mysql = "com.mysql.cj.jdbc.Driver";

	private String Driver;
	
	private String ip = "localhost";
	private String port = "3306";
	
	private String dataBaseUrl = "jdbc:mysql://"+ip+":"+port+"/corona?serverTimezone=UTC";
	private String dataBaseId = "root";
	private String dataBasePw = "1234";
	
	/*DB Driver*/
	public String getDriver() {
		return Driver;
	}
	public void setDriver(String driver) {
		Driver = driver;
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
		return dataBasePw;
	}
	public void setDataBasePw(String dataBasePw) {
		this.dataBasePw = dataBasePw;
	}
	
	public Connection dataBaseConnection() {
		try {
			Class.forName(mysql);
			this.conn = DriverManager.getConnection(dataBaseUrl, dataBaseId, dataBasePw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.conn;
	}//The end of Constructor
	

}//The end of Method
