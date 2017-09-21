package com.techelevator;

public class ChipItem extends Product {

	@Override
	public String getSound() {
		setName();
		setPrice();
		setSound("Crunch, Crunch, Yum!");
	}

}
