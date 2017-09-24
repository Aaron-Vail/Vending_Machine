package com.techelevator;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class VendingMachine {

	private Map<String, Stack<Product>> inventory = null; // Map passed from CLI
	private List<Product> purchases = new ArrayList<>(); // List to hold customer purchases
	private BigDecimal currentBalance = new BigDecimal("0.00");

	private WriteFile data = new WriteFile("log.txt", true);
	
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
	try{							 
		
		data.writeToFile(String.format("%-25s %-8s %s", "ADD MONEY", "$"+dollars+".00", "$"+currentBalance));
//		data.writeToFile("ADD MONEY " + "$" + dollars + ".00 " + " $" + currentBalance);
		
	}
	catch (IOException e) { 
		System.out.println(e.getMessage());
	}
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
			BigDecimal temp = currentBalance;
			currentBalance = currentBalance.subtract(getProductPrice(slot));
			purchases.add(this.inventory.get(slot).pop());
		try{		
			data.writeToFile(String.format("%-18s %-6s %-8s %s", getProductName(slot), slot, "$"+temp, "$"+currentBalance));
//				data.writeToFile(getProductName(slot) + slot1 + "$" + temp + "$" + currentBalance);
			}
		catch (IOException e) { 
				System.out.println(e.getMessage());
			}
		}
	}	

	public void finishTransaction() {
		BigDecimal beforeFinal = currentBalance;
		// return customer's money  change()
		if (currentBalance.compareTo(new BigDecimal("0")) != 0) {
			Change custChange = new Change();
			List<Integer> changeList = new ArrayList<>();
			changeList.addAll(custChange.getChange(currentBalance));
		
			System.out.println(custChange);		
		}
		// 	currentBalance updated to $0
			currentBalance = new BigDecimal("0");
		try{	
			data.writeToFile(String.format("%10s %20s %7s", "GIVE CHANGE", "$"+beforeFinal, "$"+currentBalance+".00"));
		}
	catch (IOException e) { 
			System.out.println(e.getMessage());
		}
		// currentBalance updated to $0
		currentBalance = new BigDecimal("0");
		
		// the purchases will be "consumed"
		for (Product bought : purchases) {
			System.out.println(bought.getSound());
		}
		System.out.println("Thank you for your business!");
		System.exit(1);
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

