package com.techelevator;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class VendingMachine {

	private Map<String, Stack<Product>> inventory = null; // Map passed from CLI
	//private Stack<Product> purchases = new Stack<>(); // List to hold customer purchases
	private BigDecimal currentBalance = new BigDecimal("0.00");
	
	public VendingMachine(Map<String, Stack<Product>> inventory) { // Constructor
		this.inventory = inventory;
	}
	
	@Override
	public String toString() {
		String display = null;
		
		for (Map.Entry<String, Stack<Product>> entry : inventory.entrySet()) {
			display = entry.getKey() + " " + entry.getValue() + "\n";
		}
		return display;
	}
	
	public BigDecimal balance() {
		
		return currentBalance;
	}
	
	public void addMoney(BigDecimal dollars) { // change return ??
		currentBalance = currentBalance.add(dollars);
	}
	
	public BigDecimal getProductPrice(String slot) {
		BigDecimal itemPrice = null;
		itemPrice = this.inventory.get(slot).peek().getPrice();
		return itemPrice;
	}
	
	public String getProductName(String slot) {
		String productName =  null;
		productName = this.inventory.get(slot).peek().getName();
		return productName;
	}
	
	public int getProductQuant(String slot) {
		int productQuant = this.inventory.get(slot).size();
		return productQuant;
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

