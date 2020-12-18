package spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.demo.config.SpringCoreConfig;
import spring.demo.model.User;
import spring.demo.service.UserService;

/**
 * 
 * @author Ram Niwash
 *	
 */
public class AppAutowire {
	
	
    public static void main(String[] args ){
    	
        @SuppressWarnings("resource")
		ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringCoreConfig.class);
    
        UserService userService=(UserService)applicationContext.getBean(UserService.class);
        
        System.out.println("Getting from user service........");
        
        User user=userService.getUserById("U0001");
        
        System.out.println(user);
    }
}
