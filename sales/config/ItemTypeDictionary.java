package sales.config;

import java.util.HashMap;
import java.util.Map;

public class ItemTypeDictionary {
	
	private static ItemTypeDictionary instance;
	private static Map<String, ItemType> itemTypes;		
	
	public static ItemTypeDictionary getInstance() {
		
		if(instance == null) {
			instance = new ItemTypeDictionary();
			initItemTypes();
		}
		
		return instance;
	}
	
	private static void initItemTypes() {
		itemTypes = new HashMap<String, ItemType>();
		
		// item -> type
		itemTypes.put("book", ItemType.BOOK);
		itemTypes.put("CD", ItemType.OTHER);
		itemTypes.put("chocolate", ItemType.FOOD);
		itemTypes.put("perfume", ItemType.OTHER);
		itemTypes.put("pill", ItemType.MEDICINE);
		// ... other items as required
	}
	
	public ItemType getItemType(String itemName) {
		
		for(String item : itemTypes.keySet()) {
			if(itemName.contains(item)) {
				return itemTypes.get(item);
			}
		}
		
		return ItemType.OTHER;
	}
}
