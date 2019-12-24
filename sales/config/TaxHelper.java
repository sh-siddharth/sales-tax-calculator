package sales.config;

import sales.models.Item;

public class TaxHelper {
	
	public static final double SALES_TAX = 0.1;
	public static final double IMPORT_TAX = 0.05;
	
	public static double calclulateTax(Item item) {
		double salesTax = 0.0;
		double importTax = 0.0;

		if(item.getType() == ItemType.OTHER) {
			salesTax = item.getPrice() * SALES_TAX;
		}
		
		if(item.isImported()) {
			importTax = item.getPrice() * IMPORT_TAX;
		}
		
		return roundValue(salesTax + importTax);
	}
	
	// get rounded value to nearest ceil 0.05 (1/20)
	private static double roundValue(double number) {
		return Math.ceil(number * 20.0) / 20.0;
	}
	
}
