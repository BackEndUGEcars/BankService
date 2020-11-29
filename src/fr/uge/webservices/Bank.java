package fr.uge.webservices;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Objects;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Bank {
	private final String bankJson;
	private boolean initialized = false;
	private final HashMap<String, Account> accounts = new HashMap<String, Account>();

	
	/**
	 * Constructor of Bank
	 * @param bankJson
	 */
	public Bank(String bankJson) {
		this.bankJson = Objects.requireNonNull(bankJson);
	}

	/**
	 * init the bank and put in some datas
	 * @throws IOException
	 * @throws ParseException
	 */
	public void init() throws IOException, ParseException {
		accounts.put("PJB", new Account("PJ", "Besnard", "PJB", "abcdef", 1574524));
		accounts.put("LB", new Account("Louis", "Billaut", "LB", "ghijk", 635421));
		accounts.put("AL", new Account("Armand", "Liegey", "AL", "lmnop", 524));
		initialized = true;
	}

	/**
	 * Check if the given parameters are an account
	 * @param login
	 * @param password
	 * @return true if login and password are correct 
	 */
	public boolean isAnAccount(String login, String password) {
		if (!initialized) throw new IllegalStateException("Bank must be initialized before calling any other method");
		Objects.requireNonNull(login);
		Objects.requireNonNull(password);
		Account current = accounts.get(login);
		if (current != null) {
			return current.isPassword(password);
		}
		return false;
	}

	/**
	 * return the account corresponding to the given login 
	 * @param login
	 * @return the account corresponding to the given login 
	 */
	public Account getAccount(String login) {
		if (!initialized) throw new IllegalStateException("Bank must be initialized before calling any other method");
		return accounts.get(Objects.requireNonNull(login));
	}

}
