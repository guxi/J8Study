package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class myConn {
	final static ComboPooledDataSource ds = new ComboPooledDataSource("db_score");
	
	private static Connection conn;
	public static Connection getConn(){
		try {
			
			
			conn = ds.getConnection();
			 System.out.println("���������"+ds.getMaxPoolSize());// ���������
		        System.out.println("��С������"+ds.getMinPoolSize());// ��С������
		        System.out.println("����ʹ��������"+ds.getNumBusyConnections());// ����ʹ��������
		        System.out.println("����������"+ds.getNumIdleConnections());// ����������
		        System.out.println("��������"+ds.getNumConnections());// ��������
		
		} catch (SQLException  e) {
			e.printStackTrace();
		}
		return conn;		
	}
	
	public static Connection getConn(String arg){
		try {
			ComboPooledDataSource ds = new ComboPooledDataSource(arg);	
			
			conn = ds.getConnection();
		
		} catch (SQLException  e) {
			e.printStackTrace();
		}
		return conn;		
	}
//	public static Connection getConn(){
//		try {
//			//Class.forName("com.mysql.jdbc.Driver");			
//			String url = "jdbc:mysql://localhost:3306/db_score";
//			String user="root";
//			String pass="809110";
//			conn = DriverManager.getConnection(url,user,pass);
//		
//		} catch (SQLException  e) {
//			e.printStackTrace();
//		}
//		return conn;		
//	}
	
}
