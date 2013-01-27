package com.xwfb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConn {
	public Connection getConn(){
		Connection conn = null;
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			
			try {
				
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/xwfb??useUnicode=true&characterEncoding=utf8", "root", "aa");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public void freeConn(Connection conn, Statement s, ResultSet rs) {
		try {
			if (conn != null) {

				conn.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (s != null) {
				s.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/*public void test() {
	Connection conn = getConn();
	String sql = "select id, content, createTime, title from news";
	try {
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery(sql);
		while (rs.next()) {
			System.out.print(rs.getInt("id") + "\t");
			System.out.print(rs.getString("content") + "\t");
			System.out.print(rs.getString("createTime") + "\t");
			System.out.println(rs.getString("title"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}*/
	
	
	public static void main(String[] args) {
		//DbConn dd = new DbConn();
		//dd.test();
	}
}
