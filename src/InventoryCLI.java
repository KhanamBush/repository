
import java.util.Scanner;

public class InventoryCLI {
  public static void main(String[] args) {
    ProductDAO productDAO = new ProductDAO();
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("1. Create Product");
      System.out.println("2. Update Product");
      System.out.println("3. Delete Product");
      System.out.println("4. Display All Products");
      System.out.println("5. Get Product Details");
      System.out.println("6. Exit");

      int choice = scanner.nextInt();

      switch (choice) {
        case 1:
          // Create product
        	
          break;
        case 2:
          // Update product
          break;
        case 3:
          // Delete product
          break;
        case 4:
          // Display all products
          productDAO.displayAllProducts();
          break;
        case 5:
          // Get product details
          int id = scanner.nextInt();
          Product product = productDAO.getProduct(id);
          if (product != null) {
            System.out.println(product);
          } else {
            System.out.println("Product not found");
          }
          break;
        case 6:
          // Exit
          System.exit(0);
          break;
        default:
          System.out.println("Invalid choice");
      }
    }
  }
}