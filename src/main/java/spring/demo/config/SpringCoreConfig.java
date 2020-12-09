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
		User user=new User("U0001", "ABC", "ABC", "Role1");
		return user;
	}
	
//	@Bean
	public User userB() {
		User user=new User("U0002", "XYZ", "XYZ", "Role2");
		return user;
	}
}
