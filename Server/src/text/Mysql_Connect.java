package text;

import java.sql.*;

public class Mysql_Connect {
	private Connection connection;
	private String mysql_qudong="com.mysql.jdbc.Driver";
	private String mysql_lianjie="jdbc:mysql://localhost:3306/";
	private String mysql_database="shxz130";
	private String mysql_user="root";
	private String mysql_passwd="admin";
	public Mysql_Connect()
	{
		try {
//			Class.forName("com.mysql.jdbc.Driver");	
//			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/shxz130","root","admin");
				
			Class.forName(mysql_qudong);
			connection=DriverManager.getConnection(mysql_lianjie+mysql_database,mysql_user,mysql_passwd);
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
