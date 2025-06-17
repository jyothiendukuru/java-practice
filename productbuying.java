import java.util.*;
class Product {
    private String name;
    private double price;
    private double rating;

    public Product(String name, double price, double rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public double getRating() { return rating; }

    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setRating(double rating) { this.rating = rating; }

    public String toString() {
        return "Name: " + name + " | Price: ₹" + price + " | Rating: " + rating + "/5";
    }
}

public class productbuying {
    private static List<Product> products = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Product Buying System ===");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product by Name");
            System.out.println("3. Delete Product by Name");
            System.out.println("4. Search Product by Name");
            System.out.println("5. Display All Products");
            System.out.println("6. Sort Products by Price (Low to High)");
            System.out.println("7. Sort Products by Price (High to Low)");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1: addProduct(); break;
                case 2: updateProductByName(); break;
                case 3: deleteProductByName(); break;
                case 4: searchProductByName(); break;
                case 5: displayProducts(); break;
                case 6: sortProductsByPrice(true); break;
                case 7: sortProductsByPrice(false); break;
                case 8: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 8);
    }

    private static void addProduct() {
        System.out.print("Enter product name: ");
        String name = sc.nextLine();
        System.out.print("Enter product price: ");
        double price = sc.nextDouble();
        System.out.print("Enter product rating (0 to 5): ");
        double rating = sc.nextDouble();
        sc.nextLine(); // clear buffer
        products.add(new Product(name, price, rating));
        System.out.println("Product added successfully.");
    }

    private static void updateProductByName() {
        System.out.print("Enter product name to update: ");
        String name = sc.nextLine().toLowerCase();
        for (Product pro : products) {
            if (pro.getName().toLowerCase().equals(name)) {
                System.out.print("Enter new name: ");
                pro.setName(sc.nextLine());
                System.out.print("Enter new price: ");
                pro.setPrice(sc.nextDouble());
                System.out.print("Enter new rating: ");
                pro.setRating(sc.nextDouble());
                sc.nextLine(); // clear buffer
                System.out.println("Product updated.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    private static void deleteProductByName() {
        System.out.print("Enter product name to delete: ");
        String name = sc.nextLine().toLowerCase();
        Iterator<Product> it = products.iterator();
        while (it.hasNext()) {
            if (it.next().getName().toLowerCase().equals(name)) {
                it.remove();
                System.out.println("Product deleted.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    private static void searchProductByName() {
        System.out.print("Enter product name to search: ");
        String name = sc.nextLine().toLowerCase();
        boolean found = false;
        for (Product pro : products) {
            if (pro.getName().toLowerCase().contains(name)) {
                System.out.println(pro);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching product found.");
        }
    }

    private static void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products to display.");
            return;
        }
        for (Product pro : products) {
            System.out.println(pro);
        }
    }

    private static void sortProductsByPrice(boolean ascending) {
        products.sort(Comparator.comparingDouble(Product::getPrice));
        if (!ascending) {
            Collections.reverse(products);
        }
        System.out.println("Products sorted by price (" + (ascending ? "Low to High" : "High to Low") + "):");
        displayProducts();
    }
}
