/**
 * ServiceBank.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.uge.webservices;

import java.io.IOException;
import java.util.Objects;

import org.json.simple.parser.ParseException;


public class BankService {

	
	private final Bank bank;

	/**
	 * Constructor of BankService
	 * @throws ParseException
	 */
	public BankService() throws ParseException {
		this.bank = new Bank("mon_json.json");
		try {
			this.bank.init();
		} catch (IOException  e) {
			System.out.println("Unable to init Bank, exiting ...");
		}
	}


	/**
	 * Check if the given parameters correspond to an account in the Bank
	 * @param login The user login
	 * @param password The user password
	 * @return true if parameters are correct
	 */
	private boolean login(String login, String password) {
		Objects.requireNonNull(login);
		Objects.requireNonNull(password);
		if (bank.isAnAccount(login, password)) {
			return true;
		}
		return false;
	}

	/**
	 * To add amount to the account of given login and password
	 * @param login the login
	 * @param password the password
	 * @param amount the amount
	 * @return true if successful 
	 */
	public boolean receive(String login, String password, double amount) {
		if (!login(login, password) || amount <= 0.00) return false;
		Account current = bank.getAccount(login);
		current.receive(amount);
		return true;
	}

	/**
	 * To remove amount from the account of given login and password
	 * @param login the login
	 * @param password the password
	 * @param amount the amount 
	 * @return true if successful 
	 */
	public boolean send(String login, String password, double amount) {
		if (!login(login, password) || amount <= 0.00) return false;
		Account current = bank.getAccount(login);
		current.send(amount);
		return true;
	}

	/**
	 * Check if the amount is available on the account of given login and password
	 * @param login the login 
	 * @param password the password
	 * @param amount the amount
	 * @return true if there is enough money on the account
	 */
	public boolean amountAvailable(String login, String password, double amount) {
		if (!login(login, password)) return false;
		return bank.getAccount(login).amountAvailable(amount);
	}
	
	/**
	 * Check if the given parameters correspond to an account in the Bank
	 * @param login the login
	 * @param password the password 
	 * @return true if parameters are correct
	 */
	public boolean isAnAccount(String login, String password) {
		Objects.requireNonNull(login);
		Objects.requireNonNull(password);
		if (bank.isAnAccount(login, password)) {
			return true;
		}
		return false;
	}
	
}

