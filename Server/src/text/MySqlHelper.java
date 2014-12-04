package text;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class MySqlHelper {
	Mysql_Connect ct;
	PreparedStatement ps;
	ResultSet rs;	
	public MySqlHelper()
	{
		ct=new Mysql_Connect();
	}
	//[]paras��ͨ��?��ֵ��ʽ���Է�ֹ©��ע�뷽ʽ����֤��ȫ��
	public ResultSet query(String sql,String []paras)
	{
		try {
			ps=ct.getConnection().prepareStatement(sql);		//��sql�Ĳ�����ֵ
			for(int i=0;i<paras.length;i++)
			{
				ps.setString(i+1, paras[i]);
			}
			//ִ�в�ѯ
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		//���ؽ����
		return rs;
	}
	
	public void close()
	{
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(ct!=null) ct.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	public void bianli()
	{
		rs=this.Select("select * from userbean");
		try {
			while(rs.next())
			{
				try {
					System.out.println(rs.getString(1)+rs.getString(2));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ResultSet Select(String sql)
	{
		try {
			ps=ct.getConnection().prepareStatement(sql);
			rs=ps.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public static void main(String[] args) {

		MySqlHelper cr=new MySqlHelper();
		String[] a={"11111","�Ō�"};
		cr.query("insert into userbean values(?,?)",a);
		cr.bianli();
		String[] a2={"11111"};
		cr.query("delete from userbean where uid=?",a2);
		cr.bianli();
		

		
	}
}
