import java.util.Scanner;

public class DynamicOnlineMarketplace {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number of Book products : ");
        int bookCount = sc.nextInt();
        sc.nextLine(); 

        Product<BookCategory>[] books = new Product[bookCount];
        for (int i = 0; i < bookCount; i++) {
            System.out.print("Enter Book name : ");
            String name = sc.nextLine();

            System.out.print("Enter Book price : Rs.");
            double price = sc.nextDouble();
            sc.nextLine();

            books[i] = new Product<>(name, price, new BookCategory());
        }

        System.out.print("\nEnter number of Clothing products : ");
        int clothingCount = sc.nextInt();
        sc.nextLine();

        Product<ClothingCategory>[] clothes = new Product[clothingCount];
        for (int i = 0; i < clothingCount; i++) {
            System.out.print("Enter Clothing name : ");
            String name = sc.nextLine();

            System.out.print("Enter Clothing price : Rs.");
            double price = sc.nextDouble();
            sc.nextLine();

            clothes[i] = new Product<>(name, price, new ClothingCategory());
        }

        System.out.print("\nEnter number of Gadget products : ");
        int gadgetCount = sc.nextInt();
        sc.nextLine();

        Product<GadgetCategory>[] gadgets = new Product[gadgetCount];
        for (int i = 0; i < gadgetCount; i++) {
            System.out.print("Enter Gadget name : ");
            String name = sc.nextLine();

            System.out.print("Enter Gadget price : Rs.");
            double price = sc.nextDouble();
            sc.nextLine();

            gadgets[i] = new Product<>(name, price, new GadgetCategory());
        }

        // Apply discount
        System.out.print("\nEnter discount % for Books : ");
        double bDiscount = sc.nextDouble();
        for (Product<BookCategory> p : books) {
            ProductUtility.applyDiscount(p, bDiscount);
        }

        System.out.print("Enter discount % for Clothing : ");
        double cDiscount = sc.nextDouble();
        for (Product<ClothingCategory> p : clothes) {
            ProductUtility.applyDiscount(p, cDiscount);
        }

        System.out.print("Enter discount % for Gadgets : ");
        double gDiscount = sc.nextDouble();
        for (Product<GadgetCategory> p : gadgets) {
            ProductUtility.applyDiscount(p, gDiscount);
        }

        // Display all products
        System.out.println("\n---- Products After Discount ----");
        for (Product<BookCategory> p : books) {
        	p.displayProduct();
        }
        for (Product<ClothingCategory> p : clothes) {
        	p.displayProduct();
        }
        for (Product<GadgetCategory> p : gadgets) {
        	p.displayProduct();
        }
	}
}
