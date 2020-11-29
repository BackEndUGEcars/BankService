package fr.uge.webservices;

import java.util.Objects;

public class Account {

	private final String firstName;
	private final String lastName;
	private final String login;
	private final String password;
	private double balance;
	
	
	/**
	 * Constructor of account
	 * @param firstName the first name
	 * @param lastName	the last name 
	 * @param login	the login 
	 * @param password the password 
	 */
	public Account(String firstName, String lastName, String login, String password) {
		this(firstName, lastName, login, password, 0.00);
	}
	
	/**
	 * Constructor of account
	 * @param firstName the first name
	 * @param lastName	the last name 
	 * @param login	the login 
	 * @param password the password 
	 * @param balance the balance 
	 */
	public Account(String firstName, String lastName, String login, String password, double balance) {
		this.firstName = Objects.requireNonNull(firstName);
		this.lastName = Objects.requireNonNull(lastName);
		this.login = Objects.requireNonNull(login);
		this.password = Objects.requireNonNull(password);
		this.balance = balance;
	}
	
	/**
	 * To add money to this account
	 * @param amount the amount to add
	 * @return true if successful 
	 */
	public boolean receive(double amount) {
		if (amount <= 0.00) return false;
		balance += amount;
		return true;
	}
	
	/**
	 * To remove money from this account
	 * @param amount the amount to remove 
	 * @return true if successful
	 */
	public boolean send(double amount) {
		if (amount <= 0.00) return false;
		balance -= amount;
		return true;
	}
	
	/**
	 * Get the balance of the account 
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * Check if the amount is available
	 * @param amount the amount to check
	 * @return true if there is enough money 
	 */
	public boolean amountAvailable(double amount) {
		return amount <= balance;
	}
	
	/**
	 * Get the login of the account 
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	
	/**
	 * Check if the given parameter is the login
	 * @param login the login
	 * @return true if the login is the good one 
	 */
	public boolean isLogin(String login) {
		Objects.requireNonNull(login);
		return this.login.equals(login);
	}
	
	/**
	 * Check if the given parameter is the password
	 * @param password the password
	 * @return true if the password is the good one 
	 */
	public boolean isPassword(String password) {
		Objects.requireNonNull(password);
		return this.password.equals(password);
	}
	
	/**
	 * Get the last name 
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * get the first name
	 * @return the firstName 
	 */
	public String getFirstName() {
		return firstName;
	}
	
	
	
}
