package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class VendingMachine {

	private Map<String, Stack<Product>> inventory = null; // Map passed from CLI
	private List<Product> purchases = new ArrayList<>(); // List to hold customer purchases
	private BigDecimal currentBalance = new BigDecimal("0.00");
	private boolean soldOut = false;
	
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
	
	public BigDecimal getBalance() {
		
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
	
	public void purchase(String slot) {
		if (currentBalance.compareTo(getProductPrice(slot)) == -1 ) {
			System.out.println("Insufficient Funds.");
		}
		else {
			currentBalance = currentBalance.subtract(getProductPrice(slot));
			purchases.add(this.inventory.get(slot).pop());
		}
	}	

	public void finishTransaction() {
		
		// return customer's money  change()
		
		// currentBalance updated to $0
		
		// the purchases will be "consumed"
	}
	
	public boolean isSoldOut(String slot) {
		if (getProductQuant(slot) == 0) {
			soldOut = true;
		}
		else {
			soldOut = false;
		}
		return soldOut;
	}
}

