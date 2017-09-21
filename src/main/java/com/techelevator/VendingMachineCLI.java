package com.techelevator;

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
	private static final String SELECT_PRODUCT_MENU_OPTION_LIST_ITEMS = "List items";
	private static final String SELECT_PRODUCT_MENU_OPTION_ENTER_ITEM_TO_PURCHASE = "Enter item to purchase";
	private static final String[] SELECT_PRODUCT_MENU_OPTIONS = {SELECT_PRODUCT_MENU_OPTION_LIST_ITEMS, 
															SELECT_PRODUCT_MENU_OPTION_ENTER_ITEM_TO_PURCHASE};
	private static final String FEED_MONEY_OPTION_FEED_MONEY = "Feed money";
	private static final String FEED_MONEY_OPTION_RETURN_TO_PURCHASE_MENU ="Return to Purchase menu";
	private static final String[] FEED_MONEY_OPTIONS = {FEED_MONEY_OPTION_FEED_MONEY,
														FEED_MONEY_OPTION_RETURN_TO_PURCHASE_MENU};
//	private static final String SELECT_VM_ITEMS_CHIPS = "Chips";
//	private static final String SELECT_VM_ITEMS_CANDY = "Candy"; 
//	private static final String SELECT_VM_ITEMS_DRINKS = "Drinks";
//	private static final String SELECT_VM_ITEMS_GUM = "Gum";
//	private static final String[] SELECT_VM_ITEMS_OPTIONS = {SELECT_VM_ITEMS_CHIPS,
//															SELECT_VM_ITEMS_CANDY,
//															SELECT_VM_ITEMS_DRINKS,
//															SELECT_VM_ITEMS_GUM};
	
	private Menu menu;
	private VendingMachine newVM = null;
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}
	
	public void run() {
		newVM = new VendingMachine(new VendingMachineFileReader().loadInventory());
		
		while(true) {
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				String choice2 = (String)menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
				
				while (true) {
					if (choice2.equals(PURCHASE_MENU_OPTION_FEED_MONEY)){
						// feed money
					}
					else if (choice2.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
						// Select items
						String choice3 = (String)menu.getChoiceFromOptions(SELECT_PRODUCT_MENU_OPTIONS);
						
						while (true) {
							if (choice3.equals(SELECT_PRODUCT_MENU_OPTION_LIST_ITEMS)) {
								// List items
							}
							else if (choice3.equals(SELECT_PRODUCT_MENU_OPTION_ENTER_ITEM_TO_PURCHASE)) {
								
							}
						}
					}
				}
			} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				
					
				
			}
		}
	}
	
	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		
		
		cli.run();
	}
}