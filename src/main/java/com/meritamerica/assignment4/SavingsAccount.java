package com.meritamerica.assignment4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SavingsAccount extends BankAccount {final static double INTEREST_RATE = 1.0/100;


SavingsAccount(double openingBalance) {
	super(openingBalance,INTEREST_RATE);
}
SavingsAccount(long accountNumber, double balance, double interestRate){
	super(accountNumber, balance, interestRate);
}
SavingsAccount(double balance, double interestRate, java.util.Date accountOpenedOn){
	super(balance, interestRate, accountOpenedOn);

}

SavingsAccount(long accountNumber, double balance, double interestRate, java.util.Date accountOpenedOn){
	super(accountNumber, balance, interestRate, accountOpenedOn);
	
}
public static SavingsAccount readFromString(String s) throws ParseException {
	String[] tokens = s.split(",");
	long accountNumber = Long.parseLong(tokens[0]);
	double b = Double.parseDouble(tokens[1]);
	double interest = Double.parseDouble(tokens[2]);
	SimpleDateFormat sdfmt1 = new SimpleDateFormat("dd/MM/yy");

	Date date = sdfmt1.parse(tokens[3]);

	SavingsAccount account = new SavingsAccount(accountNumber, b, interest, date);
	return account;
	
	
	
}

}
