package com.self.builderdesignpattern;

import com.self.builderdesignpattern.User.UserBuilder;

public class Driver {

	public static void main(String[] args) {
		UserBuilder builder= new UserBuilder();  //temp stored in heap
		builder.setName("abc");
		builder.setAge(23);
		builder.setEmail("anjdfj");
		User u= builder.build(); // stored in heap until the garbage collector collects it
		System.out.println(u);
		  
		User user= new User.UserBuilder()
				.setName("abc")
				.setAge(21)
				.setEmail("abc@gmai.com")
				.build();
		
		System.out.println(user);
	}

}
