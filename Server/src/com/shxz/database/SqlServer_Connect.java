package com.shxz.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlServer_Connect {
	private Connection connection;
	private String sql_lianjie="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String sql_url="jdbc:sqlserver://localhost:1433;DatabaseName=";
	private String sql_database="stuinfomanager";
	private String sql_user="sa";
	private String sql_passwd="zb650709";
	public SqlServer_Connect()
	{
		try {
//			Class.forName("com.mysql.jdbc.Driver");	
//			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/shxz130","root","admin");
				
			Class.forName(sql_lianjie);
			connection=DriverManager.getConnection(sql_url+sql_database,sql_user,sql_passwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void close()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
}
