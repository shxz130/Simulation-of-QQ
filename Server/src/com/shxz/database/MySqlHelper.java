package com.shxz.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlHelper {
//	Mysql_Connect ct;
//	PreparedStatement ps;
//	ResultSet rs;	
//	public MySqlHelper()
//	{
//		ct=new Mysql_Connect();
//	}
//	//[]paras��ͨ��?��ֵ��ʽ���Է�ֹ©��ע�뷽ʽ����֤��ȫ��
//	public ResultSet query(String sql,String []paras)
//	{
//		try {
//			ps=(PreparedStatement)ct.getConnection().prepareStatement(sql,paras);		//��sql�Ĳ�����ֵ
//			for(int i=0;i<paras.length;i++)
//			{
//				ps.setString(i+1, paras[i]);
//			}
//			//ִ�в�ѯ
//			rs=ps.executeQuery();
//		} catch (Exception e) {
//			e.printStackTrace();
//			// TODO: handle exception
//		}
//		//���ؽ����
//		return rs;
//	}
//	
//	public void close()
//	{
//		try {
//			if(rs!=null) rs.close();
//			if(ps!=null) ps.close();
//			if(ct!=null) ct.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//			// TODO: handle exception
//		}
//	}
//	public void bianli()
//	{
//		rs=Select("select * from userbean");
//		try {
//			while(rs.next())
//			{
//				try {
//					System.out.println(rs.getString(1)+rs.getString(2));
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	public ResultSet Select(String sql)
//	{
//		try {
//			ps=(PreparedStatement) ct.getConnection().createStatement();
//			rs=ps.executeQuery();
//			return rs;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return rs;
//	}
	public static void main(String[] args) {
		System.out.println("ddd");
//		MySqlHelper cr=new MySqlHelper();
//		String[] a={"11111","�Ō�"};
//		cr.query("insert into userbean values(?,?)",a);
//		cr.bianli();

		
	}
}
