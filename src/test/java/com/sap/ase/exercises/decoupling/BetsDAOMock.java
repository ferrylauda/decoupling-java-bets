package com.sap.ase.exercises.decoupling;

public class BetsDAOMock extends BetsDAO {

	@Override
	public int getLimit() {
		return 100;

	}
}
