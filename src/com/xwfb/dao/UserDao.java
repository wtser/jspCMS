package com.xwfb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.xwfb.bean.User;

public class UserDao {
	private Connection conn;
	private Statement s;
	private ResultSet rs=null;
	private PreparedStatement ps;
	private DbConn dbconn = new DbConn();
	
	private void setUser(User user) {
		try {
			user.setId(rs.getInt("id"));
			user.setLogTime(rs.getInt("logTime"));
			user.setName(rs.getString("name"));
			user.setPass(rs.getString("pass"));
			user.setPrivileges(rs.getInt("privileges")) ;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<User> getAllUser() {
		conn = dbconn.getConn();
		String sql = "select id, name, pass, logTime, privileges from user";
		//String sql = "select * from user";
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sql);
			ArrayList<User> listUser = new ArrayList<User>();

			while (rs.next()) {
				User user = new User();
				setUser(user);
				listUser.add(user);	
			}
			return listUser;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public boolean insertUser(User user){
		conn = dbconn.getConn();
		
		String sql = "insert into user ( id ,name, pass, privileges ,logTime) values (?, ?, ?, ?,?)";
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, user.getId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getPass());
			ps.setInt(4, user.getPrivileges());
			ps.setInt(5, user.getLogTime());
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbconn.freeConn(conn, ps, null);
		}
		return false;
	}
	
	public boolean updateUser(User user){
		conn = dbconn.getConn();
		String sql = "update user set name = ?, pass= ?,logTime=?,privileges=? where id =? ";
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getName());
			ps.setString(2, user.getPass());
			ps.setInt(3, user.getLogTime());
			ps.setInt(4, user.getPrivileges());
			ps.setInt(5, user.getId());
			
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbconn.freeConn(conn, ps, null);
		}
		return false;
	}
	
	public boolean deleteUser(int userid){
		conn = dbconn.getConn();
		String sql = "delete from user where id = ? ";
		try {			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbconn.freeConn(conn, ps, null);
		}
		return false;
	}

}
