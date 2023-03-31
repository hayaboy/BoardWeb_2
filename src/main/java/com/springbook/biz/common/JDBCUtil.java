package com.springbook.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;  //commons-beanutils, commons-dbcp넣어줘야 함
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JDBCUtil {
	
	public static Connection getConnection() {
		
		try {
			Class.forName("org.h2.Driver");
			return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn){
		if (rs != null) {
			try {
				if (!rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("ResultSet 관련 에러");
//				e.printStackTrace();
			}finally {
				rs=null;
			}
			
		}
		
		
		if (stmt != null) {
			
			try {
				if (!stmt.isClosed()) {
					stmt.close();
				}
			} catch (SQLException e) {
				System.out.println("PreparedStatement 관련 에러");
				//e.printStackTrace();
			}finally {
				stmt=null;
			}
			
			
		}
		
		
		if (conn != null) {
			try {
				if (!conn.isClosed())
					conn.close();
			} catch (Exception e) {
				System.out.println("Connection 관련 에러");
				//e.printStackTrace();
			} finally {
				conn = null;
			}
		}
		
		
		
	}

}
