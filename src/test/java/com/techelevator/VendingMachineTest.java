package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {

	VendingMachine sut;
	
	@Before
	public void setUp() throws Exception {
		Stack<Product> products = new Stack<>();
		products.push(new ChipItem("Lays", new BigDecimal("0.75")));
		products.push(new ChipItem("Lays", new BigDecimal("0.75")));
		products.push(new ChipItem("Lays", new BigDecimal("0.75")));
		products.push(new ChipItem("Lays", new BigDecimal("0.75")));
		products.push(new ChipItem("Lays", new BigDecimal("0.75")));
		
		Map<String, Stack<Product>> inventory = new HashMap<>();
		inventory.put("A1", products);
		
		sut = new VendingMachine(inventory);
		
	}

	@Test
	public void test() {
		sut.addMoney(new BigDecimal("2.00"));
		sut.purchase("A1");
		sut.finishTransaction();
		assertEquals(new BigDecimal("0"), sut.getBalance());
	}
	
	@Test
	public void testMultiPurchase() {
		sut.addMoney(new BigDecimal("3.00"));
		sut.purchase("A1");
		sut.purchase("A1");
		sut.purchase("A1");
	
		assertEquals("Lays", sut.getProductName("A1"));
		assertEquals( 3, sut.getPurchases().size());
	}
	
	@Test
	public void testNotEnoughMoney() {
		sut.addMoney(new BigDecimal("0.50"));
		sut.purchase("A1");
		sut.finishTransaction();
		assertEquals(new BigDecimal("0"), sut.getBalance());
	}
	
	@Test
	public void testNotValidItem() {
		sut.addMoney(new BigDecimal("2.00"));
		sut.purchase("C1");
		sut.finishTransaction();
		assertEquals(new BigDecimal("0"), sut.getBalance());
	}
}
