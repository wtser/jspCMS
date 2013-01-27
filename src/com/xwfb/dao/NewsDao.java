package com.xwfb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.xwfb.bean.News;



public class NewsDao {
	private Connection conn;
	private Statement s;
	private ResultSet rs=null;
	private PreparedStatement ps;
	private DbConn dbconn = new DbConn();
	
	
	
	
	
	public ArrayList<News> getNewsAll(){
		conn = dbconn.getConn();
		String sql = "select id,author,content,createTime,newsType,newsClassId,title from news order by id desc  ";
		ArrayList<News> al = new ArrayList<News>();
		try {
			s =conn.createStatement();
			rs= s.executeQuery(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			ps = conn.prepareStatement(sql);
			News news =null;
			while (rs.next()) {
				
				news= new News();
				news.setId(rs.getInt("id"));
				news.setAuthor(rs.getString("author"));
				news.setContent(rs.getString("content"));
				news.setCreateTime(rs.getString("createTime"));
				news.setNewsType(rs.getInt("newsType"));
				news.setNewsClassId(rs.getInt("newsClassId"));
				news.setTitle(rs.getString("title"));
				
				al.add(news);
				
			}
			return al;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<News> getNewsBySortName(int newsClassId){
		conn = dbconn.getConn();
		//用注释内的方法提示空指针错误
		//String sql = "select id,author,content,createTime,newsType,newsClassId,title from news  where newsClassId= "+newsClassId;
		String sql = "select * from news  where newsClassId="+newsClassId+" order by id desc ";
		ArrayList<News> al = new ArrayList<News>();
		try {
			s =conn.createStatement();
			rs= s.executeQuery(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			ps = conn.prepareStatement(sql);
			News news =null;
			while (rs.next()) {
				
				news= new News();
				news.setId(rs.getInt("id"));
				news.setAuthor(rs.getString("author"));
				news.setContent(rs.getString("content"));
				news.setCreateTime(rs.getString("createTime"));
				news.setNewsType(rs.getInt("newsType"));
				news.setNewsClassId(rs.getInt("newsClassId"));
				news.setTitle(rs.getString("title"));
				
				al.add(news);
				
				
			}
			return al;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<News> getNewsBySearch(int newsClassId,String title){
		conn = dbconn.getConn();
		//用注释内的方法提示空指针错误
		//String sql = "select id,author,content,createTime,newsType,newsClassId,title from news  where newsClassId= "+newsClassId;
		//String sql = "select * from news  where newsClassId="+newsClassId+" and title like "+title+" order by id desc ";
		String sql = "select * from news where newsClassId="+newsClassId;
		ArrayList<News> al = new ArrayList<News>();
		try {
			s =conn.createStatement();
			rs= s.executeQuery(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			ps = conn.prepareStatement(sql);
			News news =null;
			while (rs.next()) {
				
				news= new News();
				news.setId(rs.getInt("id"));
				news.setAuthor(rs.getString("author"));
				news.setContent(rs.getString("content"));
				news.setCreateTime(rs.getString("createTime"));
				news.setNewsType(rs.getInt("newsType"));
				news.setNewsClassId(rs.getInt("newsClassId"));
				news.setTitle(rs.getString("title"));
				
				al.add(news);
				
				
			}
			return al;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean insertNews(News news){
		conn = dbconn.getConn();
		
		String sql = "insert into news (id, newsClassId, title, content, author, newsType, createTime) values (?, ?, ?, ?, ? ,? ,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, news.getId());
			ps.setInt(2, news.getNewsClassId());
			ps.setString(3, news.getTitle());
			ps.setString(4, news.getContent());
			ps.setString(5, news.getAuthor());
			ps.setInt(6, news.getNewsType());
			
			ps.setString(7, news.getCreateTime());
			
			
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
	
	public boolean updateNews(News news){
		conn = dbconn.getConn();
		
		String sql = "update news set newsClassId = ?, title= ?, content = ?,  newsType=?  where id =? ";
		try {
			
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, news.getNewsClassId());
			ps.setString(2, news.getTitle());
			ps.setString(3, news.getContent());
			//ps.setString(4, news.getAuthor());
			ps.setInt(4, news.getNewsType());
			
			ps.setInt(5, news.getId());
			
			
			
			
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
	
	public boolean deleteNews(int newsid){
		conn = dbconn.getConn();
		
		String sql = "delete from news where id =? ";
		try {
			
			
			ps = conn.prepareStatement(sql);
		
			ps.setInt(1, newsid);
			
			
			
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
	
	public News getNewsById(int newsid){
		conn = dbconn.getConn();
		String sql = "select id,author,content,createTime,newsType,newsClassId,title from news where id = " + newsid;
		try {
			 s = conn.createStatement();
			 rs = s.executeQuery(sql);
			News news = new News();
			if (rs.next()) {
				
				news.setId(rs.getInt("id"));
				news.setAuthor(rs.getString("author"));
				news.setContent(rs.getString("content"));
				news.setCreateTime(rs.getString("createTime"));
				news.setNewsType(rs.getInt("newsType"));
				news.setNewsClassId(rs.getInt("newsClassId"));
				
				news.setTitle(rs.getString("title"));
				
			}
			return news;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
