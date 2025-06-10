package com.self.builderdesignpattern;

/**
 * Internal working of @Builder pattern
 */
public class User {

	private String name;
	private int age;
	private String email;


	private User(String name, int age, String email) {
		this.name=name;
		this.age=age;
		this.email=email;
	}

	public static class UserBuilder{

		private String name;
		private int age;
		private String email;

		public UserBuilder setName(String name) {
			this.name= name;
			return this;
		}

		public UserBuilder setAge(int age) {
			this.age= age;
			return this;
		}

		public UserBuilder setEmail(String email) {
			this.email=email;
			return this;
		}

		public User build() {
			return new User(name,age,email);
		}

	}

	@Override
	public String toString() {
		return "User{name:"+name+"age:"+age+"email:"+email+"}";	
	}

}
