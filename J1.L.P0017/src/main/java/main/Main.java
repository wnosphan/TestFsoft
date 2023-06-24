package main;

import controller.ProductController;
import java.util.List;
import model.Product;
import view.ProductView;

public class Main {

    public static void main(String[] args) {
        ProductController controller = new ProductController();
        ProductView view = new ProductView();

        controller.setView(view);

        while (true) {
            view.printMenu();
            int choice = view.getMenuChoice();
            switch (choice) {
                case 1:
                    controller.createProduct();
                    break;
                case 2:
                    String id = view.getProductId();
                    if (controller.productExists(id)) {
                        System.out.println("Product exists");
                    } else {
                        System.out.println("Product does not exist");
                    }
                    break;
                case 3:
                    String name = view.getProductName();
                    List<Product> searchResults = controller.searchProducts(name);
                    if (searchResults.isEmpty()) {
                        System.out.println("No products found");
                    } else {
                        view.displayProductList(searchResults);
                    }
                    break;
                case 4:
                    id = view.getProductId();
                    if (controller.productExists(id)) {
                        controller.updateProduct(id);
                    } else {
                        view.displayError("Product does not exist");
                    }
                    break;
                case 5:
                    id = view.getProductId();
                    if (controller.productExists(id)) {
                        controller.deleteProduct(id);
                    } else {
                        view.displayError("Product does not exist");
                    }
                    break;
                case 6:
                    controller.saveProducts();
                    break;
                case 7:
                    controller.printSortedProducts();
                    break;
                case 8:
                    return;
                default:
                    view.displayError("Invalid choice");
                    break;
            }
        }
    }
}