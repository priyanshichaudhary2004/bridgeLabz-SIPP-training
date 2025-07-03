package inheritance;
class Order{
	String OrderId;
	String Orderdate;
public Order(String OrderId,String Orderdate){
	this.OrderId=OrderId;
	this.Orderdate=Orderdate;
}
public String getOrderStatus() {
    return "Order placed";
}

public void displayDetails() {
    System.out.println("Order ID: " + OrderId);
    System.out.println("Order Date: " + Orderdate);
}

}
class ShippedOrder extends Order{
	String trackingnumber;
	public ShippedOrder(String OrderId,String Orderdate,String trackingnumber){
		super(OrderId,Orderdate);
		this.trackingnumber=trackingnumber;
	}
	public String getOrderStatus() {
        return "Order shipped";
    }
	 public void displayDetails() {
	        super.displayDetails();
	        System.out.println("Tracking Number: " + trackingnumber);
	    }
}
class DeliveredOrder extends ShippedOrder{
	String deliveryDate;
public	DeliveredOrder(String OrderId,String Orderdate,String trackingnumber,String deliveryDate){
		super(OrderId,Orderdate,trackingnumber);
		this.deliveryDate=deliveryDate;
	}
public String getOrderStatus() {
    return "Order delivered";
}
public void displayDetails() {
    super.displayDetails();
    System.out.println("Delivery Date: " + deliveryDate);
}
}

public class order_managment {
	 public static void main(String[] args) {
	        Order order = new Order("ORD101", "2025-07-01");
	        ShippedOrder shipped = new ShippedOrder("ORD102", "2025-07-01", "TRK123456");
	        DeliveredOrder delivered = new DeliveredOrder("ORD103", "2025-07-01", "TRK654321", "2025-07-03");

	        System.out.println("\n--- Order ---");
	        order.displayDetails();
	        System.out.println("Status: " + order.getOrderStatus());

	        System.out.println("\n--- Shipped Order ---");
	        shipped.displayDetails();
	        System.out.println("Status: " + shipped.getOrderStatus());

	        System.out.println("\n--- Delivered Order ---");
	        delivered.displayDetails();
	        System.out.println("Status: " + delivered.getOrderStatus());
	    }
}
