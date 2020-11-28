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

	public Bank(String bankJson) {
		this.bankJson = Objects.requireNonNull(bankJson);
	}

	public void init() throws IOException, ParseException {
		accounts.put("PJB", new Account("PJ", "Besnard", "PJB", "abcdef", 1574524));
		accounts.put("LB", new Account("Louis", "Billaut", "LB", "ghijk", 635421));
		accounts.put("AL", new Account("Armand", "Liegey", "AL", "lmnop", 524));
		initialized = true;
		//System.out.println(this.getClass().getResourceAsStream("test.json"));
		
		/*var json = IOUtils.toString(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("test.json")), StandardCharsets.UTF_8);
		JSONParser parser = new JSONParser();


		JSONObject jsonObject = (JSONObject) parser.parse(json);
		//	            System.out.println(jsonObject);

		var cars = (JSONArray) jsonObject.get("cars");
		System.out.println(cars);*/



		// initialiser ici la bank avec un json fraichement parsé
		
	}

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

	public Account getAccount(String login) {
		if (!initialized) throw new IllegalStateException("Bank must be initialized before calling any other method");
		return accounts.get(Objects.requireNonNull(login));
	}

}
