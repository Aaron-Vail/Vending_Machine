package com.techelevator;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.techelevator.Change;

public class ChangeTest {

	Change sut;
	
	@Before
	public void setUp() throws Exception {
		sut = new Change();
	}

	@Test
	public void testQuartersOnly() {
		sut.getChange(new BigDecimal("2.00"));
		assertEquals(8, sut.getQuarters());
		
	}

	@Test
	public void testDimes() {
		sut.getChange(new BigDecimal);
	}
}
