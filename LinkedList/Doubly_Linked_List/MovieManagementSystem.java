import java.util.Scanner;

class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode next, prev;

    public MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieManagement {
    private MovieNode head;
    private MovieNode tail;

    // 1. Add movie at beginning
    public void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // 1. Add movie at end
    public void addAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // 1. Add at specific position (1-based index)
    public void addAtPosition(int position, String title, String director, int year, double rating) {
        if (position <= 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        MovieNode newNode = new MovieNode(title, director, year, rating);
        MovieNode current = head;
        int count = 1;

        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        if (current == null || current.next == null) {
            addAtEnd(title, director, year, rating);
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
    }

    // 2. Remove movie by title
    public void removeByTitle(String title) {
        MovieNode current = head;
        while (current != null && !current.title.equalsIgnoreCase(title)) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Movie not found.");
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

        System.out.println("Movie removed successfully.");
    }

    // 3. Search by director or rating
    public void search(String keyword) {
        MovieNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.director.equalsIgnoreCase(keyword) || String.valueOf(current.rating).equals(keyword)) {
                System.out.println("Title : " + current.title + ", Director : " + current.director + ", Year: " + current.year + ", Rating: " + current.rating);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No movie found with that director or rating.");
    }

    // 4. Display forward
    public void displayForward() {
        if (head == null) {
            System.out.println("No movies to display.");
            return;
        }
        MovieNode current = head;
        while (current != null) {
            System.out.println("Title : " + current.title + ", Director : " + current.director + ", Year : " + current.year + ", Rating : " + current.rating);
            current = current.next;
        }
    }

    // 4. Display reverse
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No movies to display.");
            return;
        }
        MovieNode current = tail;
        while (current != null) {
            System.out.println("Title : " + current.title + ", Director : " + current.director + ", Year : " + current.year + ", Rating : " + current.rating);
            current = current.prev;
        }
    }

    // 5. Update rating by title
    public void updateRating(String title, double newRating) {
        MovieNode current = head;
        while (current != null && !current.title.equalsIgnoreCase(title)) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Movie not found.");
        } else {
            current.rating = newRating;
            System.out.println("Rating updated successfully.");
        }
    }
}

public class MovieManagementSystem {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        MovieManagement mms = new MovieManagement();
        int choice;

        do {
            System.out.println("\n--- Movie Management System ---");
            System.out.println("1. Add Movie");
            System.out.println("2. Remove Movie by Title");
            System.out.println("3. Search by Director or Rating");
            System.out.println("4. Display Movies (Forward)");
            System.out.println("5. Display Movies (Reverse)");
            System.out.println("6. Update Movie Rating");
            System.out.println("7. Exit");
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();
            sc.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Enter title : ");
                    String title = sc.nextLine();
                    System.out.print("Enter director : ");
                    String director = sc.nextLine();
                    System.out.print("Enter year of release : ");
                    int year = sc.nextInt();
                    System.out.print("Enter rating : ");
                    double rating = sc.nextDouble();
                    System.out.print("Enter position (1 = beginning, -1 = end, else index) : ");
                    int pos = sc.nextInt();
                    if (pos == 1) {
                        mms.addAtBeginning(title, director, year, rating);
                    } else if (pos == -1) {
                        mms.addAtEnd(title, director, year, rating);
                    } else {
                        mms.addAtPosition(pos, title, director, year, rating);
                    }
                    break;
                case 2:
                    System.out.print("Enter movie title to remove : ");
                    String removeTitle = sc.nextLine();
                    mms.removeByTitle(removeTitle);
                    break;
                case 3:
                    System.out.print("Enter Director Name or Rating to search : ");
                    String searchKey = sc.nextLine();
                    mms.search(searchKey);
                    break;
                case 4:
                    mms.displayForward();
                    break;
                case 5:
                    mms.displayReverse();
                    break;
                case 6:
                    System.out.print("Enter movie title to update : ");
                    String updateTitle = sc.nextLine();
                    System.out.print("Enter new rating : ");
                    double newRating = sc.nextDouble();
                    mms.updateRating(updateTitle, newRating);
                    break;
                case 7:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);
	}
}
