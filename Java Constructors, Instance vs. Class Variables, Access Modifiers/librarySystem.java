package oops;
class Book{
	public int ISBN;
	protected String title;
	private String author;
	
	Book(int ISBN, String title, String author){
		this.ISBN=ISBN;
		this.title=title;
		this.author=author;
	}
	public String getauthor() {
		return author;
	}
	public void  setauthor(String author) {
		this.author=author;
	}
	public void displayInfo(){
		System.out.println("ISBN is: "+ISBN);
		System.out.println("title is: "+title);
		System.out.println("author name is: "+author);
		
	}
	
}
class Ebook extends Book{
	  Ebook(int ISBN, String author){
		 super(ISBN,"Ebook title", author);
	 }
	  public void displayInfoEbook(){
			System.out.println("ISBN is: "+ISBN);
			System.out.println("author name is: "+getauthor());
			
		}
	  
	
}

public class librarySystem {
	public static void main(String[]args) {
		Book b1=new Book(234,"Ramayan","valmiki");
		b1.displayInfo();
		
		b1.setauthor("kabirdas");
		
		b1.displayInfo();
	
		Ebook e1=new Ebook(123,"groky");
		e1.displayInfoEbook();
	}
}
