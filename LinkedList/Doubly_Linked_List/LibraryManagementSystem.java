import java.util.Scanner;

class BookNode {
    String title;
    String author;
    String genre;
    int bookID;
    boolean isAvailable;
    BookNode next, prev;

    public BookNode(String title, String author, String genre, int bookID, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookID = bookID;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class LibraryManagement {
    private BookNode head;
    private BookNode tail;

    // 1. Add at beginning
    public void addAtBeginning(String title, String author, String genre, int bookID, boolean isAvailable) {
        BookNode newNode = new BookNode(title, author, genre, bookID, isAvailable);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // 1. Add at end
    public void addAtEnd(String title, String author, String genre, int bookID, boolean isAvailable) {
        BookNode newNode = new BookNode(title, author, genre, bookID, isAvailable);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // 1. Add at specific position (1-based index)
    public void addAtPosition(int position, String title, String author, String genre, int bookID, boolean isAvailable) {
        if (position <= 1) {
            addAtBeginning(title, author, genre, bookID, isAvailable);
            return;
        }

        BookNode newNode = new BookNode(title, author, genre, bookID, isAvailable);
        BookNode current = head;
        int count = 1;

        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        if (current == null || current.next == null) {
            addAtEnd(title, author, genre, bookID, isAvailable);
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
    }

    // 2. Remove a book by ID
    public void removeByID(int bookID) {
        BookNode current = head;
        while (current != null && current.bookID != bookID) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Book not found.");
            return;
        }

        if (current == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else if (current == tail) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        System.out.println("Book removed successfully.");
    }

    // 3. Search by title or author
    public void search(String keyword) {
        BookNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.title.equalsIgnoreCase(keyword) || current.author.equalsIgnoreCase(keyword)) {
                displayBook(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No matching book found.");
    }

    // 4. Update availability by ID
    public void updateAvailability(int bookID, boolean newStatus) {
        BookNode current = head;
        while (current != null && current.bookID != bookID) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Book not found.");
        } else {
            current.isAvailable = newStatus;
            System.out.println("Availability status updated.");
        }
    }

    // 5. Display forward
    public void displayForward() {
        if (head == null) {
            System.out.println("No books available.");
            return;
        }
        BookNode current = head;
        while (current != null) {
            displayBook(current);
            current = current.next;
        }
    }

    // 5. Display reverse
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No books available.");
            return;
        }
        BookNode current = tail;
        while (current != null) {
            displayBook(current);
            current = current.prev;
        }
    }

    // 6. Count books
    public int countBooks() {
        int count = 0;
        BookNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Helper method to print a book
    private void displayBook(BookNode book) {
        System.out.println("Book ID : " + book.bookID + ", Title : " + book.title +
                ", Author : " + book.author + ", Genre : " + book.genre +
                ", Available : " + (book.isAvailable ? "Yes" : "No"));
    }
}

public class LibraryManagementSystem {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        LibraryManagement lms = new LibraryManagement();
        int choice;

        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book by ID");
            System.out.println("3. Search Book by Title/Author");
            System.out.println("4. Update Book Availability");
            System.out.println("5. Display All Books (Forward)");
            System.out.println("6. Display All Books (Reverse)");
            System.out.println("7. Count Total Books");
            System.out.println("8. Exit");
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book Title : ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author : ");
                    String author = sc.nextLine();
                    System.out.print("Enter Genre : ");
                    String genre = sc.nextLine();
                    System.out.print("Enter Book ID : ");
                    int id = sc.nextInt();
                    System.out.print("Is Available (true/false) : ");
                    boolean avail = sc.nextBoolean();
                    System.out.print("Enter Position (1 = beginning, -1 = end, else index) : ");
                    int pos = sc.nextInt();
                    if (pos == 1)
                        lms.addAtBeginning(title, author, genre, id, avail);
                    else if (pos == -1)
                        lms.addAtEnd(title, author, genre, id, avail);
                    else
                        lms.addAtPosition(pos, title, author, genre, id, avail);
                    break;
                case 2:
                    System.out.print("Enter Book ID to remove : ");
                    int removeID = sc.nextInt();
                    lms.removeByID(removeID);
                    break;
                case 3:
                    System.out.print("Enter Title or Author to search : ");
                    String keyword = sc.nextLine();
                    lms.search(keyword);
                    break;
                case 4:
                    System.out.print("Enter Book ID to update : ");
                    int updateID = sc.nextInt();
                    System.out.print("New Availability (true/false) : ");
                    boolean status = sc.nextBoolean();
                    lms.updateAvailability(updateID, status);
                    break;
                case 5:
                    lms.displayForward();
                    break;
                case 6:
                    lms.displayReverse();
                    break;
                case 7:
                    System.out.println("Total number of books : " + lms.countBooks());
                    break;
                case 8:
                    System.out.println("Exiting system.");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 8);
	}
}
