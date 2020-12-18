package spring.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import spring.demo.model.User;
import spring.demo.service.UserService;

/**
 * 
 * @author Ram Niwash
 *
 */
@Configuration
public class SpringCoreConfig {

	@Bean(name="userA")
	@org.springframework.context.annotation.Scope("prototype")
	public User userA() {
		//Constructor field injection
		User user=new User("U0001", "Ram Niwash", "Ram Niwash", "Super Admin");
		return user;
	}
	
	@Bean
	public User userB() {
		//Setter field injection
		User user=new User();
		user.setUserID("U0002");
		user.setUserName("Parmod");
		user.setPassword("Parmod");
		user.setRole("Admin");
		return user;
	}
	
	@Bean
	public UserService userService() {
		return new UserService();
	}
}
