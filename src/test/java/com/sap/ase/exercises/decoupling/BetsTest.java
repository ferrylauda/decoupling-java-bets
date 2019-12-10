package com.sap.ase.exercises.decoupling;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class BetsTest {

	Bets bets;

	@Before
	public void setup() {
		BetsDAO betsDaoMocked = mock(BetsDAO.class);
		
		when(betsDaoMocked.getLimit()).thenReturn(100);
//		doReturn(100).when(betsDaoMocked.getLimit());
		
		bets = new Bets(betsDaoMocked);
	}

	@Test(expected = NotEnoughPlayers.class)
	public void noBetPlaced_shouldThrow() {
		bets.areEven();
	}

	@Test(expected = NotEnoughPlayers.class)
	public void oneBetPlaced_shouldThrow() {
		bets.bet("john", 1);
		bets.areEven();
	}

	@Test
	public void givenTwoBetsPlaced_sameAmount() {
		bets.bet("john", 1);
		bets.bet("frank", 1);
		assertThat(bets.areEven(), is(true));
	}

	@Test
	public void givenTwoBetsPlaced_differentAmount() {
		bets.bet("john", 1);
		bets.bet("frank", 2);
		assertThat(bets.areEven(), is(false));
	}
}
