package spring.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import spring.demo.model.User;

public class UserService {
	
	@Autowired
	@Qualifier("userA")
	private User user;
	
	public User getUserById(String id) throws RuntimeException{
		if(this.user.getUserID().equals(id)) {
			return user;
		}
		throw new RuntimeException("user not found");
	}
}
