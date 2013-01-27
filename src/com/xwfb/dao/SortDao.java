package com.xwfb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.xwfb.bean.Sort;

public class SortDao {
	private Connection conn;
	private Statement s;
	private ResultSet rs=null;
	private PreparedStatement ps;
	private DbConn dbconn = new DbConn();
	
	private void setSort(Sort sort) {
		try {
			sort.setId(rs.getInt("id"));
			sort.setSortName(rs.getString("sortName"));
			sort.setSortLevel(rs.getInt("sortLevel"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Sort> getAllSort() {
		conn = dbconn.getConn();
		String sql = "select id, sortName, sortLevel from sort order by id ";
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sql);
			ArrayList<Sort> listSort = new ArrayList<Sort>();

			while (rs.next()) {
				Sort sort = new Sort();
				setSort(sort);
				listSort.add(sort);	
			}
			return listSort;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public ArrayList<Sort> getSortById(int newsClassId) {
		conn = dbconn.getConn();
		//String sql = "select id, sortName, sortLevel from sort order by id ";
		String sql = "select * from sort where id="+newsClassId;
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sql);
			ArrayList<Sort> listSort = new ArrayList<Sort>();

			while (rs.next()) {
				Sort sort = new Sort();
				setSort(sort);
				listSort.add(sort);	
			}
			return listSort;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public ArrayList<Sort> getSubSortById(int newsClassId) {
		conn = dbconn.getConn();
		//String sql = "select id, sortName, sortLevel from sort order by id ";
		String sql = "select * from sort where sortLevel="+newsClassId;
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sql);
			ArrayList<Sort> listSort = new ArrayList<Sort>();

			while (rs.next()) {
				Sort sort = new Sort();
				setSort(sort);
				listSort.add(sort);	
			}
			return listSort;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	
	
	public boolean insertSort(Sort sort){
		conn = dbconn.getConn();
		
		String sql = "insert into sort ( id ,sortName, sortLevel) values (?, ?, ?)";
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, sort.getId());
			ps.setString(2, sort.getSortName());
			ps.setInt(3, sort.getSortLevel());

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
	
	public boolean updateSort(Sort sort){
		conn = dbconn.getConn();
		String sql = "update sort set sortName = ?, sortLevel= ? where id =? ";
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, sort.getSortName());
			ps.setInt(2, sort.getSortLevel());
			ps.setInt(3, sort.getId());
			
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
	
	public boolean deleteSort(int sortid){
		conn = dbconn.getConn();
		String sql = "delete from sort where id = ? ";
		try {			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sortid);
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
