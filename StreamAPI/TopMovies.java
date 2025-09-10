import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TopMovies {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        List<Movie> movies = new ArrayList<>();

        System.out.print("Enter number of movies : ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.print("Enter movie name : ");
            String name = sc.nextLine();
            System.out.print("Enter rating : ");
            double rating = sc.nextDouble();
            System.out.print("Enter release year : ");
            int year = sc.nextInt();
            sc.nextLine(); 
            movies.add(new Movie(name, rating, year));
        }

        System.out.println("\nTop 5 Trending Movies : ");
        movies.stream()
                .sorted(Comparator.comparingDouble(Movie::getRating).reversed()
                        .thenComparing(Movie::getReleaseYear, Comparator.reverseOrder()))
                .limit(5)
                .forEach(System.out::println);
	}
}
