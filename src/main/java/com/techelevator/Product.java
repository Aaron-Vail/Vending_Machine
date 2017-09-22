package com.techelevator;

import java.math.BigDecimal;

public abstract class Product {
	@SuppressWarnings("unused")
	private String sound;
	private String name;
	private BigDecimal price;
	
	public Product(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}
	
	public abstract String getSound();
	
	public String getName() {
		return name;
	}
	
	public BigDecimal getPrice() {
		return price;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return  name + " " + price;
	}
}
