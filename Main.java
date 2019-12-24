import sales.models.Invoice;
import sales.InputReader;
import sales.TaxCalculator;

public class Main {
	
	public static void main(String[] args) {
		
		String inputFile = "../inputs/";
		
		if (args.length == 0) {
			System.out.println("no input file provided.");
			System.out.println("<usage> : java Main <input_file_name>");
			System.out.println("note : place your input file inside the inputs directory.");

			System.exit(0);
		} else {
			inputFile += args[0];
		}

		InputReader inputReader = new InputReader(inputFile);

		Invoice invoice = new Invoice();
		invoice.setItems(inputReader.readInput());

		TaxCalculator calculator = new TaxCalculator(invoice);
		calculator.printInvoice();
	}
}
