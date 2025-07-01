package java_class_and_obj;

public class item {
	int itemCode;
	String itemName;
	int price;
item(int itemCode,String itemName, int price){
	this.itemCode=itemCode;
	 this.itemName=itemName;
	 this.price=price;
}
public void displayInfo() {
	System.out.println("item code is: "+itemCode);
	System.out.println("item name is: "+itemName);
	System.out.println("item price is: "+price);
	
}
public void totalCost(int quantity) {
	double totalCost=price*quantity;
	System.out.println("total cost is: "+totalCost);
}
public static void main(String[]args) {
	item i1= new item(6,"box1",900);
	i1.displayInfo();
	i1.totalCost(4);
}

}
