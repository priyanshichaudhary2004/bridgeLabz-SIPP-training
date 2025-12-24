package java_class_and_obj;

public class MobilePhone {
	String brand;
	String model; 
	int price;
MobilePhone(String brand,String model,int price){
this.brand=brand;
this.model=model;
this.price=price;
}
public void mobileDetails() {
	System.out.println("brand name is: "+ brand);
	System.out.println("model name is:"+ model);
	System.out.println("price of the mobile phone is:"+ price);
}

public static void main(String[]args) {
	MobilePhone  m1=new MobilePhone ("samsung", "S20", 85000);
	m1.mobileDetails();
}
}