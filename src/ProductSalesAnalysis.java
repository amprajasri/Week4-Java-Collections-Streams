import java.util.*;
import java.util.stream.*;

class Sale {
    String productId;
    int quantity;
    double price;

    Sale(String productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
}

class ProductSales {
    String productId;
    double totalRevenue;

    ProductSales(String productId, double totalRevenue) {
        this.productId = productId;
        this.totalRevenue = totalRevenue;
    }

    @Override
    public String toString() {
        return productId + " - $" + totalRevenue;
    }
}

public class ProductSalesAnalysis {
    public static void main(String[] args) {
        List<Sale> sales = Arrays.asList(
                new Sale("P1", 15, 20.0),
                new Sale("P2", 8, 50.0),
                new Sale("P3", 12, 30.0),
                new Sale("P4", 20, 10.0),
                new Sale("P5", 5, 100.0),
                new Sale("P6", 30, 5.0),
                new Sale("P7", 11, 60.0)
        );

        // 1. Filter sales with quantity > 10
        List<Sale> filtered = sales.stream()
                .filter(s -> s.quantity > 10)
                .collect(Collectors.toList());

        // 2. Transform into ProductSales (productId, totalRevenue)
        List<ProductSales> productSalesList = filtered.stream()
                .map(s -> new ProductSales(s.productId, s.quantity * s.price))
                .collect(Collectors.toList());

        // 3. Sort by totalRevenue descending
        productSalesList.sort((p1, p2) -> Double.compare(p2.totalRevenue, p1.totalRevenue));

        // 4. Top 5 products
        List<ProductSales> top5 = productSalesList.stream()
                .limit(5)
                .collect(Collectors.toList());

        // Output
        System.out.println("Top 5 Products by Total Revenue:");
        top5.forEach(System.out::println);
    }
}
