package fr.uge.webservices;

import java.util.Objects;

public class Account {

	private final String firstName;
	private final String lastName;
	private final String login;
	private final String password;
	private double balance;
	
	public Account(String firstName, String lastName, String login, String password) {
		this(firstName, lastName, login, password, 0.00);
	}
	
	public Account(String firstName, String lastName, String login, String password, double balance) {
		this.firstName = Objects.requireNonNull(firstName);
		this.lastName = Objects.requireNonNull(lastName);
		this.login = Objects.requireNonNull(login);
		this.password = Objects.requireNonNull(password);
		this.balance = balance;
	}
	
	public boolean receive(double amount) {
		if (amount <= 0.00) return false;
		balance += amount;
		return true;
	}
	
	public boolean send(double amount) {
		if (amount <= 0.00) return false;
		balance -= amount;
		return true;
	}
	
	
	public double getBalance() {
		return balance;
	}
	
	public boolean amountAvailable(double amount) {
		return amount <= balance;
	}
	
	public String getLogin() {
		return login;
	}
	
	public boolean isLogin(String login) {
		Objects.requireNonNull(login);
		return this.login.equals(login);
	}
	
	public boolean isPassword(String password) {
		Objects.requireNonNull(password);
		return this.password.equals(password);
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	
	
}
