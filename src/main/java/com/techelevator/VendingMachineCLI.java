package com.techelevator;

import java.util.Scanner;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
													   MAIN_MENU_OPTION_PURCHASE };
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY ="Feed money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, 
															PURCHASE_MENU_OPTION_SELECT_PRODUCT, 
															PURCHASE_MENU_OPTION_FINISH_TRANSACTION };
//	private static final String SELECT_PRODUCT_MENU_OPTION_LIST_ITEMS = "List items";
//	private static final String SELECT_PRODUCT_MENU_OPTION_ENTER_ITEM_TO_PURCHASE = "Enter item to purchase";
//	private static final String[] SELECT_PRODUCT_MENU_OPTIONS = {SELECT_PRODUCT_MENU_OPTION_LIST_ITEMS, 
//															SELECT_PRODUCT_MENU_OPTION_ENTER_ITEM_TO_PURCHASE};
	private static final String SELECT_VM_ITEMS_CHIPS = "Chips";
	private static final String SELECT_VM_ITEMS_CANDY = "Candy"; 
	private static final String SELECT_VM_ITEMS_DRINKS = "Drinks";
	private static final String SELECT_VM_ITEMS_GUM = "Gum";
	private static final String SELECT_VM_ITEMS_Return = "Return to previous menu";
	private static final String[] SELECT_VM_ITEMS_OPTIONS = {SELECT_VM_ITEMS_CHIPS, SELECT_VM_ITEMS_CANDY, SELECT_VM_ITEMS_DRINKS,
															SELECT_VM_ITEMS_GUM, SELECT_VM_ITEMS_Return};
	
	private Menu menu;
	private VendingMachine newVM = null;
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}
	
	public void run() {
		newVM = new VendingMachine(new VendingMachineFileReader().loadInventory());
		
		while(true) {
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			// 		System.out.println("\nCurrent Balance $" + getBalance());
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				String choice1 = (String)menu.getChoiceFromOptions(SELECT_VM_ITEMS_OPTIONS);
				
				while(true) {
					if(choice1.equals(SELECT_VM_ITEMS_CHIPS)) {
						for (int i = 1; i < 5; i++) {
							System.out.println(String.format("%-5s %-25s %1s %-5s %1s %1d %1s", "A"+ i, newVM.getProductName("A" + i), 
															"$", newVM.getProductPrice("A" + i), "(", newVM.getProductQuant("A" + i), ")"));
						}  
						break;
					}
					else if (choice1.equals(SELECT_VM_ITEMS_CANDY)) {
						for (int i = 1; i < 5; i++) {
							System.out.println(String.format("%-5s %-25s %1s %-5s %1s %1d %1s", "A"+ i, newVM.getProductName("B" + i),
															"$", newVM.getProductPrice("B" + i), "(", newVM.getProductQuant("B" + i), ")"));
						}
						break;
					}
						
					else if (choice1.equals(SELECT_VM_ITEMS_DRINKS)) {
						for (int i = 1; i < 5; i++) {
							System.out.println(String.format("%-5s %-25s %1s %-5s %1s %1d %1s", "A"+ i, newVM.getProductName("C" + i),
															"$", newVM.getProductPrice("C" + i), "(", newVM.getProductQuant("C" + i), ")"));
						}
						break;
					}
						
					else if (choice1.equals(SELECT_VM_ITEMS_GUM)) {
						for (int i = 1; i < 5; i++) {
							System.out.println(String.format("%-5s %-25s %1s %-5s %1s %1d %1s", "D"+ i, newVM.getProductName("D" + i),
															"$", newVM.getProductPrice("D" + i), "(", newVM.getProductQuant("D" + i), ")"));
						}
						break;
					}
					else {
						break;
					}
				}

			} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {  // Main Menu Option #2 : Purchase Menu
				
				while (true) {
					String choice2 = (String)menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					
					if (choice2.equals(PURCHASE_MENU_OPTION_FEED_MONEY)){  // 
						
						newVM.addMoney(menu.getDecimalFromUser("message"));
						
						System.out.println("\nCurrent Balance $" + newVM.getBalance());
						
						if (choice2.equals("1")) {
							newVM.addMoney(menu.getDecimalFromUser("message"));
							break;
						}
						else if (choice2.equals("2")) {
							break;
						}
					}
					else if (choice2.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {

//						newVM.purchase(slot);

						System.out.println("Please enter the location of your purchase: (ex. A1, B2");
						@SuppressWarnings("resource")
						Scanner userInput = new Scanner(System.in);
						String line = userInput.nextLine().toUpperCase();
						newVM.purchase(line);
						System.out.println("\nCurrent Balance $" + newVM.getBalance());

						
					}
					else if (choice2.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
						newVM.finishTransaction();
						break;
					}
				}
					
				
			}
			//break;
		}
	}
	
	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		
		
		cli.run();
	}
}
