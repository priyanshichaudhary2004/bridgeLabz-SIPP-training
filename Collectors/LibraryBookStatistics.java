import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
import java.util.IntSummaryStatistics;
import java.util.Map;

public class LibraryBookStatistics {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        List<Book> books = new ArrayList<>();

        System.out.print("Enter number of books : ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter details for Book " + i + " : ");

            System.out.print("Title : ");
            String title = sc.nextLine();

            System.out.print("Genre : ");
            String genre = sc.nextLine();

            System.out.print("Pages : ");
            int pages = sc.nextInt();
            sc.nextLine(); 

            books.add(new Book(title, genre, pages));
        }

        Map<String, IntSummaryStatistics> statsByGenre =
            books.stream()
                 .collect(Collectors.groupingBy(
                     Book::getGenre,
                     Collectors.summarizingInt(Book::getPages)
                 ));

        System.out.println("\nLibrary Statistics by Genre : ");
        statsByGenre.forEach((genre, stats) -> {
            System.out.println("Genre : " + genre);
            System.out.println("  Total Pages : " + stats.getSum());
            System.out.println("  Average Pages : " + stats.getAverage());
            System.out.println("  Max Pages : " + stats.getMax());
            System.out.println();
        });
    }
}