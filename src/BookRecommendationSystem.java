import java.util.*;
import java.util.stream.*;

class Book {
    String title;
    String author;
    String genre;
    double rating;

    Book(String title, String author, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }
}

class BookRecommendation {
    String title;
    double rating;

    BookRecommendation(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return title + " - Rating: " + rating;
    }
}

public class BookRecommendationSystem {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Dune", "Frank Herbert", "Science Fiction", 4.5),
                new Book("Neuromancer", "William Gibson", "Science Fiction", 4.2),
                new Book("Foundation", "Isaac Asimov", "Science Fiction", 4.3),
                new Book("Hyperion", "Dan Simmons", "Science Fiction", 4.6),
                new Book("Snow Crash", "Neal Stephenson", "Science Fiction", 4.1),
                new Book("The Martian", "Andy Weir", "Science Fiction", 4.4),
                new Book("Ender's Game", "Orson Scott Card", "Science Fiction", 4.0),
                new Book("Ready Player One", "Ernest Cline", "Science Fiction", 4.2),
                new Book("Blindsight", "Peter Watts", "Science Fiction", 4.3),
                new Book("Old Man's War", "John Scalzi", "Science Fiction", 4.1),
                new Book("Altered Carbon", "Richard K. Morgan", "Science Fiction", 4.05)
        );

        // 1. Filter
        List<Book> filtered = books.stream()
                .filter(b -> b.genre.equalsIgnoreCase("Science Fiction") && b.rating > 4.0)
                .collect(Collectors.toList());

        // 2. Transform
        List<BookRecommendation> recommendations = filtered.stream()
                .map(b -> new BookRecommendation(b.title, b.rating))
                .collect(Collectors.toList());

        // 3. Sort
        recommendations.sort((b1, b2) -> Double.compare(b2.rating, b1.rating));

        // 4. Paginate (top 10 books, 5 per page)
        List<BookRecommendation> top10 = recommendations.stream()
                .limit(10)
                .collect(Collectors.toList());

        System.out.println("Page 1:");
        top10.stream().limit(5).forEach(System.out::println);

        System.out.println("\nPage 2:");
        top10.stream().skip(5).limit(5).forEach(System.out::println);
    }
}
