package sales;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sales.config.ItemTypeDictionary;
import sales.config.TaxHelper;
import sales.models.Item;

public class InputReader {
	
	private String filePath;
	
	public InputReader(String filePath) {
		this.filePath = filePath;
	}
	
	public ArrayList<Item> readInput() {
		ArrayList<Item> items = new ArrayList<Item>();
		
		try {
			InputStream is = InputReader.class.getResourceAsStream(this.filePath);
			Scanner scanner = new Scanner(is);
			while (scanner.hasNextLine()) {
				
				String line = scanner.nextLine();
				
				Item item = getItemFromString(line);
				if(item != null) {
					items.add(item);
				}				
			}
			scanner.close();
		} catch (Exception e) {
			System.out.println("Error occured while reading file: " + filePath);
			e.printStackTrace();
			items = null;
		}
		
		return items;
	}
	
	private Item getItemFromString(String line) {		

		// read line as -> (price) (imported? name) at (price)
		Pattern pattern = Pattern.compile("(\\d+) (.*) at (.*)");
		Matcher matcher = pattern.matcher(line);

		if(matcher.find()) {
			Item item = new Item();
			
			item.setQuantity(Integer.parseInt(matcher.group(1).trim()));
			item.setPrice(Double.parseDouble(matcher.group(3).trim()));
			
			String itemName = matcher.group(2);
			
			// if imported, set import flag and remove "imported" from name
			if(itemName.contains("imported")) {
				item.setImported(true);
				itemName = itemName.replace("imported", "").trim();
			}
			
			item.setName(itemName);
			
			item.setType(ItemTypeDictionary.getInstance().getItemType(itemName));
			item.setTax(TaxHelper.calclulateTax(item));
			
			return item;
		}
		
		return null;
	}
}
