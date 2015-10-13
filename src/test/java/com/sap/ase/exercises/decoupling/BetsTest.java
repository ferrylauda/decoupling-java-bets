package com.sap.ase.exercises.decoupling;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BetsTest {

	private class BetsForTesting extends Bets {

		@Override
		protected int getMaxAmount() {
			return 10;
		}
	}
	
	@Test(expected = NotEnoughPlayers.class)
	public void noBetPlaced_shouldThrow() {
		Bets bets = new BetsForTesting();
		bets.areEven();
	}

	@Test(expected = NotEnoughPlayers.class)
	public void oneBetPlaced_shouldThrow() {
		Bets bets = new BetsForTesting();
		bets.bet("john", 1);
		bets.areEven();
	}

	@Test
	public void givenTwoBetsPlaced_sameAmount() {
		Bets bets = new BetsForTesting();
		bets.bet("john", 1);
		bets.bet("frank", 1);
		assertThat(bets.areEven(), is(true));
	}

	@Test
	public void givenTwoBetsPlaced_differentAmount() {
		Bets bets = new BetsForTesting();
		bets.bet("john", 1);
		bets.bet("frank", 2);
		assertThat(bets.areEven(), is(false));
	}
}
