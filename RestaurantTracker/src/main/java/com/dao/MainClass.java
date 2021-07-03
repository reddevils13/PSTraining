package com.dao;

import java.util.List;

import com.to.*;

public class MainClass {

	public static void main(String[] args) {
		
		try {
			RestaurantDao rd = new RestaurantDao();
			List<Restaurants> l1 = rd.getAllRestaurant();
			l1.forEach(System.out::println);
			System.out.println("---------------");
			
			TableDao td = new TableDao();
			//List<Tables> l2 = td.getAllTables();
			//l2.forEach(System.out::println);
			
			UserDao ud = new UserDao();
			User user = new User("u8","asdfg@emailcom","asdfgh","asdfgh","12345678");
			ud.insertStudent(user);
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		

	}

}
