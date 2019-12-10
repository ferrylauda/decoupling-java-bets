package com.sap.ase.exercises.decoupling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Bets {

	private final BetsDAO betsDAO;

	public Bets(BetsDAO betsDAO) {
		this.betsDAO = betsDAO;
	}

	private final Map<String, Integer> bets = new HashMap<String, Integer>();

	public void bet(String player, int amount) {

		int limit = betsDAO.getLimit();
		if (amount > limit) {
			throw new ExceedsBetLimit(amount + " exceeds maximum bet limit of " + limit);
		} else {
			bets.put(player, amount);
		}

	}

	public boolean areEven() throws NotEnoughPlayers {
		if (bets.keySet().size() < 2) {
			throw new NotEnoughPlayers();
		}

		return (new HashSet<>(bets.values()).size() == 1);
	}
}
