package inheritance;
class books{
	String title;
    int publicationYear;

    books(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}
class Author extends books {
    String name;
    String bio;

    Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear); 
        this.name = name;
        this.bio = bio;
    }

   
    void displayInfo() {
        super.displayInfo();  // display book details
        System.out.println("Author Name: " + name);
        System.out.println("Bio: " + bio);
    }
}

public class book_system {
	public static void main(String[] args) {
        Author a1 = new Author(
            "The Silent Patient",
            2019,
            "Alex Michaelides",
            "A British-Cypriot author ."
        );

        a1.displayInfo();
}
}