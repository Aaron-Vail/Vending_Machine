package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VendingMachine {

	private Map<String, List<Product>> inventory = null; // Map passed from CLI
	private List<Product> purchases = new ArrayList<>(); // List to hold customer purchases
	private BigDecimal currentBalance = new BigDecimal("0.00");
	
	public VendingMachine(Map<String, List<Product>> inventory) { // Constructor
		this.inventory = inventory;
	}
	
	public String toString() {
		String display = null;
		
		for (Map.Entry<String, List<Product>> entry : inventory.entrySet()) {
			display = entry.getKey() + " " + entry.getValue() + "\n";
		}
		return display;
	}
	public BigDecimal balance() {
		
		return currentBalance.subtract();
	}
	
	public void addMoney(BigDecimal dollars) { // change return ??
		currentBalance = currentBalance.add(dollars);
	}
	
//	public Product purchase(String slot) {
//		
//		
//		return Product; //return a product variable
//	}	
//	
//	public Change completeTransaction() {
//		
//		return Change; // return a change variable
//	}
//	
//	public boolean isSoldOut(String slot) {
//		
//		return // return true or false if item is sold out
//	}
}
