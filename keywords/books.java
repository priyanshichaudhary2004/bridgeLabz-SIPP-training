package key_words;

public class books {
static String libraryName="oxford";

String title;
String author;

final int isbn;

books(String title,String author,int isbn){
	this.title=title;
	this.author=author;
	this.isbn=isbn;
}


public static String displayLibraryName() {
	return libraryName;
}
public void displayDetails(books obj) {
	System.out.println("book name is : "+ obj.title);
	System.out.println("book author name is : "+ obj.author);
	System.out.println("book isbn number is : "+ obj.isbn);
}
public static void main(String[]args) {
	books b1=new books("novel","justin",22);
	
	System.out.println("library name is: "+displayLibraryName());
	
	b1.displayDetails(b1);
}
}
