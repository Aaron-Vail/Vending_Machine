package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineFileReader {
	public Map<String, List<Product>> loadInventory() {
		File inventoryList = new File("vendingmachine.csv");
		
		Map<String, List<Product>> productMap = new HashMap<>();
		
		try(Scanner inventoryInput = new Scanner(inventoryList)) {
			String line = null;
			String[] parts;
			
			while (inventoryInput.hasNextLine()) {
				line = inventoryInput.nextLine();
				parts = line.split("\\|");
				
				List<Product> products = new ArrayList<>();
				
				if (parts[0].contains("A")) {
					for (int i = 0; i < 5; i++) {
					products.add(new ChipItem(parts[1], new BigDecimal(parts[2])));
					}
				}
				else if (parts[0].contains("B")) {
					for (int i = 0; i < 5; i++) {
					products.add(new CandyItem(parts[1], new BigDecimal(parts[2])));
					}
				}
				else if (parts[0].contains("C")) {
					for (int i = 0; i < 5; i++) {
					products.add(new DrinkItem(parts[1], new BigDecimal(parts[2])));
					}
				}
				else {
					for (int i = 0; i < 5; i++) {
					products.add(new GumItem(parts[1], new BigDecimal(parts[2])));
					}
				}
				
				productMap.put(parts[0], products);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return productMap;
	}
	
}
