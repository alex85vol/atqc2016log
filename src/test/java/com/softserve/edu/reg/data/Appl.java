package com.softserve.edu.reg.data;

public class Appl {

	public static void main(String[] args) {
//		User user = new User("firstname", "lastname",
//				"email", "login", "password", "community");
		//
//		User user = new User();
//		user.setFirstname("firstname");
//		user.setLastname("lastname");
//		user.setEmail("email");
//		user.setLogin("login");
//		user.setPassword("password");
//		user.setCommunity("community");
		//
//		User user = new User()
//				.setFirstname("firstname")
//				.setLastname("lastname")
//				.setEmail("email")
//				.setLogin("login")
//				.setPassword("password")
//				.setCommunity("community");
		//
		IUser user = User.get()
				.setFirstname("firstname")
				.setLastname("lastname")
				.setEmail("email")
				.setLogin("login")
				.setPassword("password")
				.setCommunity("community")
				.build();
		//
		System.out.println(user.getFirstname());
	}
}
