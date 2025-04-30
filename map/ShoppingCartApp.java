import java.util.*;

class ShoppingCart {
    private Map<String, Double> hashMapProducts = new HashMap<>();
    private Map<String, Double> linkedHashMapProducts = new LinkedHashMap<>();
    private Map<String, Double> treeMapProducts = new TreeMap<>(Comparator.comparingDouble(hashMapProducts::get));

    public void addProduct(String productName, double price) {
        hashMapProducts.put(productName, price);
        linkedHashMapProducts.put(productName, price);
        treeMapProducts.put(productName, price);
    }

    public void removeProduct(String productName) {
        hashMapProducts.remove(productName);
        linkedHashMapProducts.remove(productName);
        treeMapProducts.remove(productName);
    }

    public void displayProducts() {
        System.out.println("Products in HashMap (Unordered):");
        for (Map.Entry<String, Double> entry : hashMapProducts.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }

        System.out.println("\nProducts in LinkedHashMap (Order of Addition):");
        for (Map.Entry<String, Double> entry : linkedHashMapProducts.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }

        System.out.println("\nProducts in TreeMap (Sorted by Price):");
        for (Map.Entry<String, Double> entry : treeMapProducts.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }

    public double getTotalPrice() {
        return hashMapProducts.values().stream().mapToDouble(Double::doubleValue).sum();
    }

    public void clearCart() {
        hashMapProducts.clear();
        linkedHashMapProducts.clear();
        treeMapProducts.clear();
    }
}

public class ShoppingCartApp {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Laptop", 799.99);
        cart.addProduct("Smartphone", 699.99);
        cart.addProduct("Headphones", 49.99);

        cart.displayProducts();

        System.out.println("\nTotal Price: $" + cart.getTotalPrice());

        cart.removeProduct("Smartphone");

        System.out.println("\nAfter Removing Smartphone:");
        cart.displayProducts();

        cart.clearCart();
        System.out.println("\nAfter Clearing Cart:");
        cart.displayProducts();
    }
}
