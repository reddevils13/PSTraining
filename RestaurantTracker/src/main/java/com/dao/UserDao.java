package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.to.User;

public class UserDao {


	public User getUser(User user) throws Exception {
		
		Connection connection = Connectivity.getConnection();
		
		String q = "select * from user where uid = ? and password = ?";
		PreparedStatement ps = connection.prepareStatement(q);
		ps.setString(1, user.getUid());
		ps.setString(2, user.getPasswod());
		
		ResultSet rs = ps.executeQuery();
		User u=null;
		if(!rs.next()) {
			throw new Exception("username and password does not match");
		}
		else {
			u = new User(rs.getString(1),rs.getString(1),rs.getString(1),rs.getString(1),rs.getString(1));
		}
		return u;
		
	}
	
	public void insertStudent(User user) throws Exception {
		Connection connection = Connectivity.getConnection();
		
		String q = "insert into user values (?,?,?,?,?);";
		PreparedStatement preparedStatement = connection.prepareStatement(q);

		preparedStatement.setString(1, user.getUid());
		preparedStatement.setString(2, user.getEmail());
		preparedStatement.setString(3, user.getPasswod());
		preparedStatement.setString(4, user.getName());
		preparedStatement.setString(5, user.getPhone());
		
		preparedStatement.executeUpdate();
		
		
		
	}


	
}
