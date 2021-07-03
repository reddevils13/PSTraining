package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import com.to.Restaurants;

public class RestaurantDao {

	public RestaurantDao() {
	}
	
	public List<Restaurants> getAllRestaurant() throws Exception{
		
		Connection connection = Connectivity.getConnection();
//		select count(tid) from tables where rid='r1' and status='available';
		String q = "select * from restaurant;";
		PreparedStatement ps = connection.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		
		List<Restaurants> list = new ArrayList<>();
		while(rs.next()) {
			list.add(new Restaurants(rs.getString(1), rs.getString(2), rs.getString(3)));
		}
		
		return list;
	}

	public Restaurants getRestaurant(String rid) throws Exception{
		Connection connection = Connectivity.getConnection();
		String q = "select * from restaurant where rid=?";
		PreparedStatement ps = connection.prepareStatement(q);
		ps.setString(1, rid);
		Restaurants ans = null;
		ResultSet rs = ps.executeQuery();
		if(!rs.next()) {
			throw new Exception("incorrect restaurant id");
		}
		else {
			ans = new Restaurants(rs.getString(1),rs.getString(2),rs.getString(3));
		}
		return ans;
	}
	
	
	
}
