package com.softserve.edu.reg.data;

public final class UserRepository {

	private UserRepository() {
	}

	public static User getAdmin() {
		return User.get()
				.setFirstname("Адміністратор")
				.setLastname("Адміністратор")
				.setEmail("admin@admin.com")
				.setLogin("admin")
				.setPassword("admin")
				.setCommunity("Україна")
				.build();
	}

	public static User getRegistrator() {
		return User.get()
				.setFirstname("registrator")
				.setLastname("registrator")
				.setEmail("harasym@mail.ua")
				.setLogin("registrator")
				.setPassword("registrator")
				.setCommunity("Україна")
				.build(); 
	}

	public static User getNewUser() {
		return  User.get()
				.setFirstname("registrator1")
				.setLastname("registrator1")
				.setEmail("harasym@mail.ua")
				.setLogin("registrator1")
				.setPassword("registrator1")
				.setCommunity("Україна")
				.build();
	}

	// public static User getFromDB() {
	// MyDBManager dbm = new MyDBManager();
	// return dbm.getUser();
	// }

}
