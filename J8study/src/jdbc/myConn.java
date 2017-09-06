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
			 System.out.println("最大连接数"+ds.getMaxPoolSize());// 最大连接数
		        System.out.println("最小连接数"+ds.getMinPoolSize());// 最小连接数
		        System.out.println("正在使用连接数"+ds.getNumBusyConnections());// 正在使用连接数
		        System.out.println("空闲连接数"+ds.getNumIdleConnections());// 空闲连接数
		        System.out.println("总连接数"+ds.getNumConnections());// 总连接数
		
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
