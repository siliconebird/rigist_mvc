package com.mvc_model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mvc_model.domain.Users;
import com.mvc_model.util.jdbcUtil;

public class UserDaoMysqlImpl implements UserDao {

	@Override
	public Users findUserByName(String username) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		Users user = null;
		try {
			jdbcUtil.init();
			conn = jdbcUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select name,email,birthday,password from users where name='"+username+"'");
			if(rs.next()){
				 user = new Users(rs.getString("name"), rs.getString("password"), rs.getString("email"), rs.getDate("birthday"));
			}else{
				user = null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				jdbcUtil.release(conn, st, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
		
	}

	@Override
	public void saveUser(Users user) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			jdbcUtil.init();
			conn = jdbcUtil.getConnection();
			st = conn.createStatement();
			st.executeUpdate("insert into users(name,email,birthday,password) values ('"+user.getUsername()+"','"+user.getEmail()+"','"+user.getBirthday().toLocaleString()+"','"+user.getPassword()+"')");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				jdbcUtil.release(conn, st, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Users checkUser(String username, String password) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		Users user = null;
		try {
			jdbcUtil.init();
			conn = jdbcUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select name,email,birthday,password from users where name='"+username+"'and password='"+password+"' ");
			if(rs.next()){
				 user = new Users(rs.getString("name"), rs.getString("password"), rs.getString("email"), rs.getDate("birthday"));
			}else{
				user = null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				jdbcUtil.release(conn, st, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
		
	}

}
