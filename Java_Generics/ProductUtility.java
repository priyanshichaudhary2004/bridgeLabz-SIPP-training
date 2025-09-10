import java.util.ArrayList;
import java.util.List;

interface Category {
	String getCategoryName();
}

//BookCategory Subclass
class BookCategory implements Category {
	public String getCategoryName() {
		return "Books";
	}
}

//ClothingCategory Subclass
class ClothingCategory implements Category {
	public String getCategoryName() {
		return "Clothing";
	}
}

//GadgetCategory Subclass
class GadgetCategory implements Category {
	public String getCategoryName() {
		return "Gadgets";
	}
}

//Generic Product class
class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public void displayProduct() {
        System.out.println("Product : " + name +
                           ", Category : " + category.getCategoryName() +
                           ", Price : Rs." + price);
    }

    public void applyDiscount(double percentage) {
        price -= price * (percentage / 100.0);
    }
}

//Generic Utility
class ProductUtility {
	public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
		product.applyDiscount(percentage);
		System.out.println("Discount of " + percentage + "% applied.");
	}
}
