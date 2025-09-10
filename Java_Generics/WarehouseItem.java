import java.util.ArrayList;
import java.util.List;

//Abstract Class
abstract class WarehouseItem {
	private String name;
	
	WarehouseItem(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract void displayInfo();
}

//Electronics Subclass
class Electronics extends WarehouseItem {
	Electronics(String name) {
		super(name);
	}
	
	public void displayInfo() {
		System.out.println("Electronics Item : " + getName()); 
	}
}

//Groceries Subclass
class Groceries extends WarehouseItem {
	Groceries(String name) {
		super(name);
	}
	
	public void displayInfo() {
		System.out.println("Grocery Item : " + getName());
	}
}

//Furniture Subclass
class Furniture extends WarehouseItem {
	Furniture(String name) {
		super(name);
	}
	
	public void displayInfo() {
		System.out.println("Furniture Item : " + getName());
	}
}

//Generic storage class 
class Storage<T extends WarehouseItem> {
	private List<T> items = new ArrayList<>();
	
	public void addItem(T item) {
		items.add(item);
	}
	
	public List<T> getAllItems() {
		return items;
	}
}

//Wildcard utility method
class WarehouseUtility {
	public static void displayItems(List<? extends WarehouseItem> items) {
		for(WarehouseItem item : items) {
			item.displayInfo();
		}
	}
}