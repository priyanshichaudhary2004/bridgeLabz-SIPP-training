import java.util.Scanner;

public class SmartWarehouseManagementSystem {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		Storage<Electronics> eStorage = new Storage<>();
		Storage<Groceries> gStorage = new Storage<>();
		Storage<Furniture> fStorage = new Storage<>();
		
		System.out.print("Enter number of Electronics items : ");
		int eCount = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i < eCount; i++) {
			System.out.print("Enter Electronics item name : ");
			String name = sc.nextLine();
			eStorage.addItem(new Electronics(name));
		}
		
		System.out.print("Enter number of Grocery items : ");
		int gCount = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i < gCount; i++) {
			System.out.print("Enter Grocery item name : ");
			String name = sc.nextLine();
			gStorage.addItem(new Groceries(name));
		}
		
		System.out.print("Enter number of Furniture items : ");
		int fCount = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i < fCount; i++) {
			System.out.print("Enter Furniture item name : ");
			String name = sc.nextLine();
			fStorage.addItem(new Furniture(name));
		}
		
		System.out.println("\n--- Electonics Items ---");
		WarehouseUtility.displayItems(eStorage.getAllItems());
		
		System.out.println("\n--- Grocery Items ---");
		WarehouseUtility.displayItems(gStorage.getAllItems());
		
		System.out.println("\n--- Furniture Items ---");
		WarehouseUtility.displayItems(fStorage.getAllItems());
	}
}
