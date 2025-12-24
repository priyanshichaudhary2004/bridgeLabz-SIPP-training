package java_class_and_obj;
import java.util.ArrayList;
public class CartItem {
	
	String itemName;
	float price;
	int quantity;
	
	static ArrayList<CartItem>cart=new ArrayList<>();
	
	CartItem(String itemName,float price,int quantity){
	this.itemName=itemName;
	this.price=price;
	this.quantity=quantity;
	
}
public static void addItem(String itemName,float price,int quantity) {
	for(CartItem item:cart) {
		if(item.itemName.equalsIgnoreCase(itemName)) {
			item.quantity+=quantity;
		}
	}
	cart.add( new CartItem(itemName, price,quantity));	
	
	
}
public static void removeItem(String name) {
	boolean remove=false;
	for(int i=0;i<cart.size();i++) {
	if(cart.get(i).itemName.equalsIgnoreCase(name)){
		cart.remove(i);
		remove=true;
		System.out.println(name +"  item removed");
		break;
	}
		
	}if(!remove) {
		System.out.println("item not found");
	}
	
}

public static void displayInfo() {
	if(cart.isEmpty()) {
		System.out.println("cart is empty");
	}float total=0;
	System.out.println("---items in the cart--- ");
	for(CartItem item:cart) {
		float itemtotal=item.price*item.quantity;
		total+=itemtotal;
		
		System.out.println("item name:"+item.itemName+" item price: "+item.price);
		
	}System.out.println("total price is: "+total);
		
	
	
	

}
public static void main(String[]args) {
	CartItem.addItem("book",500,1);
	CartItem.addItem("dress",2800,3);
	CartItem.addItem("shirt",1009,1);
	displayInfo();
	CartItem.removeItem("dress");
	displayInfo();
	
}
}