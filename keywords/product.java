package key_words;

public class product {
	static int discount=20;
	String productName;
	float price;
	int quantity;
	
	final int productid;
	
product(String productName, float price, int quantity,int productid){
	this.productName=productName;
	this.price=price;
	this.quantity=quantity;
	this.productid=productid;
}
	
public static void updateDiscount(int newDiscount) {
	
	System.out.println("new discount is: "+newDiscount+"%");
}
public void displayDetail(Object obj) {
	if(obj instanceof product) {
		System.out.println("product name is: "+productName);
		System.out.println("product price is: "+price);
		System.out.println("product quantity is: "+quantity);
		
	}else {
		System.out.println("not a valid product");
	}
}
public static void main(String[]args) {
	product p1=new product("clutch",9000,2,24);
	p1.displayDetail(p1);
	updateDiscount(22);
	
}
}
