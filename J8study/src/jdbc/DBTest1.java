package jdbc;

import java.sql.*;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBTest1 {
	/**
	 * 
	 * @throws SQLException
	 */
	void testSQL() throws SQLException {
		//Connection conn = null;
		//Statement stmt = null;
		//ResultSet rs = null;
		//ComboPooledDataSource ds = new ComboPooledDataSource("db_score");
		String sql = "select * from student";	
		try(
				Connection conn = myConn.getConn();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)
				) 
		{
			/**
			 *  1.2.1ע������
			 */
			//Class.forName("com.mysql.jdbc.Driver");
			/**
			 *   1.2.2  ��ȡ����(Connection)
			 */
			//conn = DriverManager.getConnection(
			//		"jdbc:mysql://localhost:3306/db_score", "root", "809110");
			//final static ComboPooledDataSource ds = new ComboPooledDataSource("db_score");	
			//conn = ds.getConnection();
			//conn=myConn.getConn();
			/**
			 *    1.2.3 �������ݿ�Ĳ�������
			 */
			//stmt = conn.createStatement();
			
			/**
			 * 1.2.4 ִ��SQL���,��ȡִ�н��(ResultSet)
			 */
					
			//rs = 
			
			/**
			 * 1.2.5  ����ִ�н��(ResultSet)
			 */
				
			while (rs.next()) {
				System.out.print(rs.getString(1)+";");
				System.out.print(rs.getString(2)+";");
				System.out.println(rs.getString(5));
			}
		}
	}

	public static void main(String[] ar) throws SQLException {	
		
		DBTest1 DT=new DBTest1();
		DT.testSQL();	
	}
}
