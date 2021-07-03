package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import com.to.Restaurants;
import com.to.Tables;
public class TableDao {

	
	public List<Tables> getAllTables(String rid) throws Exception{
	
		Connection connection = Connectivity.getConnection();

		String q = "select * from tables where status='available' and rid=?;";
		PreparedStatement ps = connection.prepareStatement(q);
		ps.setString(1, rid);
		
		ResultSet rs = ps.executeQuery();
		
		List<Tables> list = new ArrayList<>();
		while(rs.next()) {
			list.add(new Tables(rs.getString(1), rs.getString(2), rs.getString(3)));
		}
		
		return list;
	}
	
	public List<Tables> getTablesOfRestaurant(String rid) throws Exception{
		
		Connection connection = Connectivity.getConnection();

		String q = "select * from tables where rid=?;";
		PreparedStatement ps = connection.prepareStatement(q);
		ps.setString(1, rid);
		ResultSet rs = ps.executeQuery();
		
		List<Tables> list = new ArrayList<>();
		while(rs.next()) {
			list.add(new Tables(rs.getString(1), rs.getString(2), rs.getString(3)));
		}
		
		return list;
	}
	public List<Tables> getTables() throws Exception{
		
		Connection connection = Connectivity.getConnection();

		String q = "select * from tables where status='available';";
		PreparedStatement ps = connection.prepareStatement(q);
		
		
		ResultSet rs = ps.executeQuery();
		
		List<Tables> list = new ArrayList<>();
		while(rs.next()) {
			list.add(new Tables(rs.getString(1), rs.getString(2), rs.getString(3)));
		}
		
		return list;
	}
	
	public void getUpdatedTables(String tid) throws Exception{
		Connection connection = Connectivity.getConnection();

		String q = "update tables set status='booked' where tid=?;";
		Tables table = new Tables();
		PreparedStatement ps = connection.prepareStatement(q);
		ps.setString(1, tid);
		ps.executeUpdate();
		
//		List<Tables> list = new ArrayList<>();
//		while(rs.next()) {
//			list.add(new Tables(rs.getString(1), rs.getString(2), rs.getString(3)));
//		}
//		
//		return list;
	}

	
	
}
