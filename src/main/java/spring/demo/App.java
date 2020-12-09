package spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.demo.config.SpringCoreConfig;
import spring.demo.model.User;

/**
 * 
 * @author Ram Niwash
 *	
 */
public class App {
	
	
    public static void main(String[] args ){
    	
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringCoreConfig.class);
    
        User user=(User)applicationContext.getBean("userA");
        
        System.out.println(user);
        
        //When only one bean is present of type User into container.
//        User user2=(User)applicationContext.getBean(User.class);
//        
//        System.out.println(user2);
    }
}
