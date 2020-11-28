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

	public BankService() throws ParseException {
		this.bank = new Bank("mon_json.json");
		try {
			this.bank.init();
		} catch (IOException  e) {
			System.out.println("Unable to init Bank, exiting ...");
		}
	}


	/**
	 * Allows users to login
	 * @param login The user login
	 * @param password The user password
	 * @return Returns -1 if the login / password don't match to any account, a connection token otherwise
	 */
	private boolean login(String login, String password) {
		Objects.requireNonNull(login);
		Objects.requireNonNull(password);
		if (bank.isAnAccount(login, password)) {
			return true;
		}
		return false;
	}


	public boolean receive(String login, String password, double amount) {
		if (!login(login, password) || amount <= 0.00) return false;
		Account current = bank.getAccount(login);
		current.receive(amount);
		return true;
	}

	public boolean send(String login, String password, double amount) {
		if (!login(login, password) || amount <= 0.00) return false;
		Account current = bank.getAccount(login);
		current.send(amount);
		return true;
	}

	public boolean amountAvailable(String login, String password, double amount) {
		if (!login(login, password)) return false;
		return bank.getAccount(login).amountAvailable(amount);
	}
	
	public boolean isAnAccount(String login, String password) {
		Objects.requireNonNull(login);
		Objects.requireNonNull(password);
		if (bank.isAnAccount(login, password)) {
			return true;
		}
		return false;
	}
	
}

