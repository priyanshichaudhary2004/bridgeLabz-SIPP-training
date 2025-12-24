package java_class_and_obj;

public class book {
String title;
String author;
int price;

book(String title,String author,int price){
	this.title=title;
	this.author=author;
	this.price=price;
	
}
public void displayInfo() {
	System.out.println("title of the book is: "+ title);
	System.out.println("author of the book is"+ author);
	System.out.println("price of the book is"+ price);
}
public static void main(String[]args) {
	book b1=new book("ramayan", "valmiki", 5000);
	b1.displayInfo();
}
}