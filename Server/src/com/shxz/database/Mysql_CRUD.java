package com.shxz.database;

import java.sql.*;
public class Mysql_CRUD {
	private Mysql_Connect ct;
	private Statement ps;
	java.sql.ResultSet rs;
	public Mysql_CRUD()
	{
		ct=new Mysql_Connect();
		try {
			ps=ct.getConnection().createStatement();
			rs=ps.executeQuery("select * from userbean");
			while(rs.next())
			{
				System.out.println(rs.getLong(1)+" "+rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Mysql_CRUD cr=new Mysql_CRUD();
	}

}
