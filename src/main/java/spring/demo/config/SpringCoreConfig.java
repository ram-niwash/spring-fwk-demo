package spring.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.demo.model.User;

/**
 * 
 * @author Ram Niwash
 *
 */
@Configuration
public class SpringCoreConfig {

	@Bean
	public User userA() {
		//Constructor field injection
		User user=new User("U0001", "ABC", "ABC", "Role1");
		return user;
	}
	
	@Bean
	public User userB() {
		//Setter setter injection
		User user=new User();
		user.setUserID("U0002");
		user.setUserName("XYZ");
		user.setPassword("XYZ");
		user.setRole("Role2");
		return user;
	}
}
