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
	
	
    public static void main( String[] args ){
    	
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringCoreConfig.class);
    
        User user=(User)applicationContext.getBean("userA");
        
        System.out.println(user);
        
        user=(User)applicationContext.getBean("userB");
        
        System.out.println(user);
        
        
    }
    
}
