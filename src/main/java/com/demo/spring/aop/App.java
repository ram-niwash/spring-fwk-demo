package com.demo.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.aop.config.SpringConfiguration;
import com.demo.spring.aop.exception.ATMException;
import com.demo.spring.aop.service.ATMService;

/**
 * 
 * @author Ram Niwash
 *
 */
public class App {
	
    
	public static void main( String[] args ) {
    
		@SuppressWarnings("resource")
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfiguration.class);
		
        ATMService atmService= applicationContext.getBean(ATMService.class);
        
        try {
			atmService.greeting();
			
			double balance=atmService.checkBalance(1111l, (short)9090);
			System.out.println("Your balance : "+balance); 
			
			atmService.withdrawAmount(1111l, (short)9090,6000d);
			
			balance=atmService.checkBalance(1111l, (short)9090);
			System.out.println("Your balance : "+balance); 
			
			String holderName=atmService.changePIN(1111l, (short)9090, (short)5050); 
			System.out.println("Hi "+holderName+" your ATM PIN changed");
			
			atmService.withdrawAmount(1111l, (short)9090,6000d);
			atmService.checkBalance(1111l, (short)9090);
			atmService.checkBalance(3333l, (short)9090);
	 			
		} catch (ATMException atmException) {
			atmException.printStackTrace();
		}
    }
}
