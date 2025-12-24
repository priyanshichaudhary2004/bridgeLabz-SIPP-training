package java_class_and_obj;

public class MovieTicket {
	String movieName;
	int seatNumber;
	int price;
	MovieTicket(String movieName,int seatNumber,int price)	{
	this.movieName=movieName;
	this.seatNumber=seatNumber;
	this.price=price;
	System.out.println("Ticket booked successfully!");
	}
public 	void displayTicketDetails() {
    System.out.println("----- Ticket Details -----");
    System.out.println("Movie Name  : " + movieName);
    System.out.println("Seat Number : " + seatNumber);
    System.out.println("Price       : ₹" + price);
}

public static void main(String[] args) {
    MovieTicket ticket = new MovieTicket("Interstellar", 10, 300);
    ticket.displayTicketDetails();
}
}
