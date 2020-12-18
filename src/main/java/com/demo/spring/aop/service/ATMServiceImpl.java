package com.demo.spring.aop.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.demo.spring.aop.exception.ATMException;
import com.demo.spring.aop.model.ATMCard;

/**
 * 
 * @author Ram Niwash
 *
 */
@Service
public class ATMServiceImpl implements ATMService{
	
	/**
	 * Create here repository 
	 */
	private Map<Long,ATMCard> cardRepository;
	
	public ATMServiceImpl() {
		cardRepository=new HashMap<>();
		ATMCard atmCard=new ATMCard(1111l,(short) 9090, 8888l, "Ram Niwash", 10000d);
		cardRepository.put(1111l, atmCard);
	}
	
	public void greeting() throws ATMException {
		System.out.println("******************************************************");
		System.out.println("*                  WELCOME TO ATM                    *");
		System.out.println("******************************************************");
	}

	public double checkBalance(long cardNumber, short atmPin) throws ATMException {
		if(this.cardRepository.containsKey(cardNumber)) {
			ATMCard atmCard=this.cardRepository.get(cardNumber);
			if(atmCard.getAtmPIN()==atmPin) {
				return atmCard.getBalance();
			}else {
				throw new ATMException("invalid ATM PIN");
			}
		}else {
			throw new ATMException("invalid card number");
		}
	}

	public void withdrawAmount(long cardNumber, short atmPin, double amount) throws ATMException {
		if(this.cardRepository.containsKey(cardNumber)) {
			ATMCard atmCard=this.cardRepository.get(cardNumber);
			if(atmCard.getAtmPIN() == atmPin) {
				double balance=atmCard.getBalance();
				if(amount>balance) {
					throw new ATMException("No sufficient balance");
				}
				balance-=amount;
				atmCard.setBalance(balance);
			}else { 
				throw new ATMException("invalid ATM PIN");
			}
		}else {
			throw new ATMException("invalid card number");
		}
	}

	public String changePIN(long cardNumber, short oldPin, short newPin) throws ATMException {
		if(this.cardRepository.containsKey(cardNumber)) {
			ATMCard atmCard=this.cardRepository.get(cardNumber);
			if(atmCard.getAtmPIN() == oldPin) {
				atmCard.setAtmPIN(newPin);
				return atmCard.getAccountHolderName();
			}else { 
				throw new ATMException("invalid ATM PIN");
			}
		}else {
			throw new ATMException("invalid card number");
		}
	}
}
