package com.demo.spring.aop.service;

import com.demo.spring.aop.exception.ATMException;

/**
 * 
 * @author Ram Niwash
 *
 */
public interface ATMService {
	
	public void greeting() throws ATMException;
	
	public double checkBalance(long cardNumber,short atmPin) throws ATMException;
	
	public void withdrawAmount(long cardNumber, short atmPin, double amount) throws ATMException;
	
	public String changePIN(long cardNumber,short oldPin,short newPin) throws ATMException;
}
