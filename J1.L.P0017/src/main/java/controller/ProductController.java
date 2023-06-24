package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Product;
import view.ProductView;

public class ProductController {

    private List<Product> products;
    private Scanner scanner;
    private ProductView view;

    public ProductController() {
        products = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void createProduct() {
        System.out.print("Enter product ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product unit price: ");
        double unitPrice = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter product quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter product status: ");
        String status = scanner.nextLine();
        products.add(new Product(id, name, unitPrice, quantity, status));
    }

    public boolean productExists(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public List<Product> searchProducts(String name) {
        List<Product> searchResults = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().contains(name)) {
                searchResults.add(product);
            }
        }
        return searchResults;
    }

    public void updateProduct(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                System.out.print("Enter new product name: ");
                String name = scanner.nextLine();
                product.setName(name);
                System.out.print("Enter new product unit price: ");
                double unitPrice = Double.parseDouble(scanner.nextLine());
                product.setUnitPrice(unitPrice);
                System.out.print("Enter new product quantity: ");
                int quantity = Integer.parseInt(scanner.nextLine());
                product.setQuantity(quantity);
                System.out.print("Enter new product status: ");
                String status = scanner.nextLine();
                product.setStatus(status);
            }
        }
    }

    public void deleteProduct(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                products.remove(product);
                break;
            }
        }
    }

    public void saveProducts() {
        // TODO: Save list of products to Product.dat file
    }

    public void printProducts() {
        for (Product product : products) {
            System.out.println(product.getId() + " | " + product.getName() + " | " + product.getUnitPrice() + " | " + product.getQuantity() + " | " + product.getStatus());
        }
    }

    public void printSortedProducts() {
        List<Product> sortedProducts = new ArrayList<>(products);
        sortedProducts.sort((p1, p2) -> {
            int result = Integer.compare(p2.getQuantity(), p1.getQuantity());
            if (result == 0) {
                result = Double.compare(p1.getUnitPrice(), p2.getUnitPrice());
            }
            return result;
        });
        view.displayProductList(sortedProducts);
    }

    public void setView(ProductView view) {
        this.view = view;
    }
}
