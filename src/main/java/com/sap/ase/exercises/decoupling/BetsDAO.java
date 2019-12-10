package com.sap.ase.exercises.decoupling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BetsDAO {
	public int getLimit() {
		try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5740/poker");
				Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery("select value from configuration where key = 'bet_limit'");
			rs.next();
			int limit = Integer.parseInt(rs.getString("bet_limit"));
			return limit;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
