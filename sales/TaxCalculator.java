package sales;

import java.text.DecimalFormat;

import sales.models.Invoice;
import sales.models.Item;

public class TaxCalculator {

	private Invoice invoice;
	
	public TaxCalculator(Invoice invoice) {
		
		this.invoice = invoice;
	}
	
	public void printInvoice() {
		
		double totalTax = 0.0;
		double totalPrice = 0.0;
		
		for(Item item : invoice.getItems()) {
			double totalItemPrice = item.getQuantity() * (item.getPrice() + item.getTax());
			System.out.println(item.toString() + getFinancialFigure(totalItemPrice));
			
			totalTax += item.getQuantity() * item.getTax();
			totalPrice += totalItemPrice;
		}
		
		System.out.println("Sales Taxes: " + getFinancialFigure(totalTax));
		System.out.println("Total: " + getFinancialFigure(totalPrice));
		
		// set total tax and price - if required
		
		// invoice.setTax(totalTax);
		// invoice.setTotal(totalPrice);
	}
	
	// get rounded value upto 2 decimal points
	private String getFinancialFigure(double number) {
		DecimalFormat df = new DecimalFormat("####0.00");
		return df.format(number);
	}
}
