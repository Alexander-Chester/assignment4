package com.meritamerica.assignment4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CDAccount extends BankAccount {
	private double balance;
	private Date date;
	private CDOffering offering;

	
	
	CDAccount(CDOffering offering, double balance){
		super(balance,offering.getInterestRate());
		this.offering = offering;
		this.balance = balance;
	}
	CDAccount(CDOffering offering,double balance, long accountNumber, java.util.Date date ){
		super(accountNumber, balance, offering.getInterestRate(), date);
		this.offering = offering;
	}
	CDAccount(long accountNumber, double balance, double interest, Date date, int term){
		
		super(accountNumber, balance, interest, date);
		this.balance = balance;
		offering = new CDOffering(term, interest);
		
	}
	pulic void setAccount() {
		this.account = new account;
	}
	

	public double getBalance() {
		return this.balance;
	}
	
	public double getInterestRate() {
		return this.offering.getInterestRate();
	}
	
	public int getTerm() {
		return this.offering.getTerm();
	}

	public Date getStartDate() {
		return this.date;
	}
	
	public long getAccountNumber() {
		return super.getAccountNumber();
	}
	
	public double futureValue() {
		return super.futureValue(this.offering.getTerm());
	}
	
	
	public boolean withdraw(double x) {
		return false;
	}
	public boolean deposit(double x) {
		return false;
	}
	public static CDAccount readFromString(String s) throws ParseException {
		String[] tokens = s.split(",");
		long accountNumber = Long.parseLong(tokens[0]);
		double b = Double.parseDouble(tokens[1]);
		double interest = Double.parseDouble(tokens[2]);
		SimpleDateFormat sdfmt1 = new SimpleDateFormat("dd/MM/yy");
	
			Date date = (Date)sdfmt1.parse(tokens[3]);
		int term = Integer.parseInt(tokens[4]);
	
		CDAccount account = new CDAccount(accountNumber, b, interest, date, term);
		return account;
	}
	
	

}
