package com.demo.spring.aop.model;

/**
 * 
 * @author Ram Niwash
 *
 */
public class ATMCard {

	private long cardNumber;
	private short atmPIN;
	private long accountNumber;
	private String accountHolderName;
	private double balance;
	
	public ATMCard() {
		super();
	}
	
	public ATMCard(long cardNumber, short atmPIN, long accountNumber, String accountHolderName, double balance) {
		super();
		this.cardNumber = cardNumber;
		this.atmPIN = atmPIN;
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public short getAtmPIN() {
		return atmPIN;
	}

	public void setAtmPIN(short atmPIN) {
		this.atmPIN = atmPIN;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.cardNumber);
	}
}
