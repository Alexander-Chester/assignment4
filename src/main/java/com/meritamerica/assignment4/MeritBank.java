package com.meritamerica.assignment4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;

public class MeritBank {
	private static AccountHolder[] accounts = new AccountHolder[0];
	private static CDOffering[] cdOfferings;
	private static int nextAccountNumber;
	private static CDOffering bestCDOffering;
	private static CDOffering secondBestCDOffering;
	private static int counterA = 0;
	private static int counterCD = 0;
	private static double totalBalance = 0;
	public static FraudQueue FQ = new FraudQueue();

	public static void addAccountHolder(AccountHolder accountHolder) {
		if (counterA == accounts.length) {
			AccountHolder[] newAccounts = new AccountHolder[counterA + 1];
			for (int i = 0; i < counterA; i++) {
				newAccounts[i] = accounts[i];
			}
			accounts = newAccounts;
		}
		accounts[counterA] = accountHolder;
		counterA++;
	}

	public static AccountHolder[] getAccountHolders() {
		return accounts;
	}

	public static CDOffering[] getCDOfferings() {
		return cdOfferings;
	}

	public static CDOffering getBestCDOffering(double depositAmount) {
		return bestCDOffering;
	}

	public static CDOffering getSecondBestCDOfferings(double depositAmount) {
		return secondBestCDOffering;
	}

	public static void clearCDOfferings() {
		cdOfferings = null;
	}

	public static void setCDOfferings(CDOffering[] offerings) {
		cdOfferings = offerings;
	}

	public static long getNextAccountNumber() {

		return nextAccountNumber;

	}

	public static double totalBalances() {
		double tB = 0;
		System.out.println("Method Total Balance" + tB);
		return tB;
	}

	public static double RecursiveFutureValue(double presentValue, double interestRate, int term) {
		return 0;
	}

	public static boolean processTransaction(Transaction transaction) 
			throws NegativeAmountException, ExceedsAvailableBalanceException, ExceedsFraudSuspicionLimitException {
		try {
            transaction.process();
            return true;
		}
		catch(NegativeAmountException e) {
            e.printStackTrace();
            return false;
        		}
	    }
	public static FraudQueue getFraudQue() {
		return FQ;
	}
	
	public static BankAccount getBankAccount(long accountId) {
		for (int i =0; i < accounts.length; i++) {
			for (int j = 0; j < accounts[i].getNumberOfCDAccounts(); j++) {
				if (accountId == accounts[i].amountCDAccounts[j].accounts) {
					return accounts[i].CDA
				}
			}
		}
	}

	
	

	public static boolean readFromFile(String fileName) throws ParseException {
		File file = new File(fileName);

		String line;
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

			line = reader.readLine();
			int n = Integer.parseInt(line);
			nextAccountNumber = n;
			line = reader.readLine();
			n = Integer.parseInt(line);
			CDOffering[] cdOffers = new CDOffering[n];
			cdOfferings = cdOffers;
			for (int i = 0; i < cdOfferings.length; i++) {
				line = reader.readLine();
				cdOfferings[i] = CDOffering.readFromString(line);

			}
			line = reader.readLine();
			n = Integer.parseInt(line);
			accounts = new AccountHolder[n];
			for (int i = 0; i < accounts.length; i++) {
				line = reader.readLine();
				accounts[i] = AccountHolder.readFromString(line);
				line = reader.readLine();
				n = Integer.parseInt(line);
				if (n != 0) {
					for (int j = 0; j < n; j++) {
						line = reader.readLine();
						CheckingAccount acc = CheckingAccount.readFromString(line);
						accounts[i].addCheckingAccount(acc);
					}
				}

				line = reader.readLine();
				n = Integer.parseInt(line);
				if (n != 0) {
					for (int k = 0; k < n; k++) {
						line = reader.readLine();
						SavingsAccount acc = SavingsAccount.readFromString(line);
						accounts[i].addSavingsAccount(acc);
					}
				}

				line = reader.readLine();
				n = Integer.parseInt(line);
				if (n != 0) {
					for (int l = 0; l < n; l++) {
						line = reader.readLine();
						CDAccount acc = CDAccount.readFromString(line);
						accounts[i].addCDAccount(acc);
					}
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			return false;
		}

		return true;

	}

	private static BufferedReader openFileReader(String s) {
		BufferedReader rd = null;
		while (rd == null) {

			try {
				rd = new BufferedReader(new FileReader(s));
			} catch (IOException ex) {
				System.out.println("Can't open that file.");
			}
		}
		return rd;
	}

	public static AccountHolder[] sortAccountHolders() {
		Arrays.sort(accounts);
		return accounts;
	}
}
