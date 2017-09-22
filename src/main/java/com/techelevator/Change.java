package com.techelevator;

public class Change {
	
	private int quarters = 0;
	private int dimes = 0;
	private int nickels = 0;
	
	public Change(BigDecimal ) {
		
	}
	
	public void changeOut(int change){
		
	while (change >= 25){
        quarters = quarters + 1;
        change = change - 25;
    }
    while (change >= 10){
        dimes = dimes + 1;
        change = change - 10;
    }
    while (change >= 5){
        nickels = nickels + 1;
        change = change - 5;
    }
//    System.out.printf("\nHere's your change:\n%d quarters, %d dimes, %d nickels and %d pennies!",
//        quarters, dimes, nickels, change);
}

	@Override
	public String toString() {
		return "Change [quarters=" + quarters + ", dimes=" + dimes + ", nickels=" + nickels + "]";
	}
}
