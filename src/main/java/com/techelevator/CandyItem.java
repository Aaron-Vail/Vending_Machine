package com.techelevator;

public class CandyItem extends Product {

	@Override
	public String getSound() {
		setName();
		setPrice();
		setSound("Munch, Munch, Yum!");
	}

}
