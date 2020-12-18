package com.demo.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.demo.spring.aop.exception.ATMException;

@Component
@Aspect
public class ATMLogAspect {

	@Before("execution(* com.demo.spring.aop.service.ATMService.greeting(..))")
	public void greetinBeforeAdvice(JoinPoint joinPoint) {
		System.out.println("----------- ATM greeting() Before Aspect ----------- : "+joinPoint.getSignature());
	}
	
	@After("execution(* com.demo.spring.aop.service.ATMService.greeting(..))")
	public void greetinAfterAdvice(JoinPoint joinPoint) {
		System.out.println("----------- ATM greeting() After Aspect ----------- : "+joinPoint.getSignature());
	}
	
	@AfterReturning (pointcut = "execution(* com.demo.spring.aop.service.ATMService.checkBalance(..))",returning = "balance")
	public double checkBalAfterReturnAdvice(JoinPoint joinPoint,double balance) {
		System.out.println("----------- ATM checkBalance(..) AfterReturning Aspect ----------- : "+joinPoint.getSignature());
		System.out.println("Your balance in Aspect Advice : "+balance);
		return balance+2;   // Will not impact the result of checkBalance(..)
	}
	
	@AfterThrowing(pointcut = "execution(* com.demo.spring.aop.service.ATMService.*(..))", throwing = "atmException")
	public void withdrawAmountAfterThrowingAdvice(JoinPoint joinPoint, ATMException atmException) {
		System.err.println("----------- ATM AfterThrowing Aspect ----------- : "+joinPoint.getSignature());
		System.err.println("Exception in ATM AfterThrowing : "+atmException.getMessage());
	}
	
	@Around(value = "execution(* com.demo.spring.aop.service.ATMService.changePIN(..))")
	public String changePINAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.err.println("----------- ATM Change PIN Around Aspect Started (Pre Action)----------- : "+proceedingJoinPoint.getSignature());
		proceedingJoinPoint.proceed();   //return the join point for execution
		System.err.println("----------- ATM Change PIN Around Aspect Ended (Post Action)----------- : "+proceedingJoinPoint.getSignature());		
		return "USER"; // Will impact the result of changePIN(..) method
	}
}
