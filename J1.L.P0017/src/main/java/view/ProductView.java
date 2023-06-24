package view;

import java.util.List;
import java.util.Scanner;
import model.Product;

public class ProductView {

    private Scanner scanner;

    public ProductView() {
        scanner = new Scanner(System.in);
    }

    public void printMenu() {
        System.out.println("1. Create product");
        System.out.println("2. Check if product exists");
        System.out.println("3. Search for product by name");
        System.out.println("4. Update product");
        System.out.println("5. Delete product");
        System.out.println("6. Save products");
        System.out.println("7. Print products");
        System.out.println("8. Quit");
    }

    public int getMenuChoice() {
        System.out.print("Enter choice: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String getProductId() {
        System.out.print("Enter product ID: ");
        return scanner.nextLine();
    }

    public String getProductName() {
        System.out.print("Enter product name: ");
        return scanner.nextLine();
    }

    public void displayProduct(Product product) {
        System.out.println(product.getId() + " | " + product.getName() + " | " + product.getUnitPrice() + " | " + product.getQuantity() + " | " + product.getStatus());
    }

    public void displayProductList(List<Product> products) {
        for (Product product : products) {
            displayProduct(product);
        }
    }

    public void displayError(String message) {
        System.out.println("Error: " + message);
    }
}
