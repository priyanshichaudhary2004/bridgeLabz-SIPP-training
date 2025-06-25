package oops;

class product{
	String productName;
	double price;
	
	//class variable
	public static int totalProducts=0;

//constructor
product(String name, double price){
	this.productName=name;
	this.price=price;
	totalProducts++;
}

public void displayProductDetails() {
	System.out.println("productname is: "+ productName+"product price is: "+price);
}


	public static void  displayTotalProducts() {
		System.out.println("total products is: "+ totalProducts);
		
		
	}
	
	
}
public class products{
	public static void main(String[]args) {
		product p1=new product("laptop",50000);
		product p2=new product("phone",30000);
		
		p1.displayProductDetails();
		p2.displayProductDetails(); 
		
		product.displayTotalProducts() ;
	}
}

