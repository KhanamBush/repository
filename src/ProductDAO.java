
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO {
  private Connection connection;

  public ProductDAO() {
    try {
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "1234");
    } catch (SQLException e) {
      System.out.println("Error connecting to database: " + e.getMessage());
    }
  }

  public void createProduct(Product product) {
    try {
      PreparedStatement statement = connection.prepareStatement("INSERT INTO products (name, price, quantity) VALUES (, ?, ?)");
      statement.setString(1, product.getName());
      statement.setDouble(2, product.getPrice());
      statement.setInt(3, product.getQuantity());
      statement.executeUpdate();
    } catch (SQLException e) {
      System.out.println("Error creating product: " + e.getMessage());
    }
  }

  public void updateProduct(Product product) {
    try {
      PreparedStatement statement = connection.prepareStatement("UPDATE products SET name = ?, price = ?, quantity = ? WHERE id = ?");
      statement.setString(1, product.getName());
      statement.setDouble(2, product.getPrice());
      statement.setInt(3, product.getQuantity());
      statement.setInt(4, product.getId());
      statement.executeUpdate();
    } catch (SQLException e) {
      System.out.println("Error updating product: " + e.getMessage());
    }
  }

  public void deleteProduct(int id) {
    try {
      PreparedStatement statement = connection.prepareStatement("DELETE FROM products WHERE id = ?");
      statement.setInt(1, id);
      statement.executeUpdate();
    } catch (SQLException e) {
      System.out.println("Error deleting product: " + e.getMessage());
    }
  }

  public Product getProduct(int id) {
    try {
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM products WHERE id = ?");
      statement.setInt(1, id);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        Product product = new Product();
        product.setId(resultSet.getInt("id"));
        product.setName(resultSet.getString("name"));
        product.setPrice(resultSet.getDouble("price"));
        product.setQuantity(resultSet.getInt("quantity"));
        return product;
      } else {
        return null;
      }
    } catch (SQLException e) {
      System.out.println("Error getting product: " + e.getMessage());
      return null;
    }
  }

  public void displayAllProducts() {
    try {
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM products");
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        Product product = new Product();
        product.setId(resultSet.getInt("id"));
        product.setName(resultSet.getString("name"));
        product.setPrice(resultSet.getDouble("price"));
        product.setQuantity(resultSet.getInt("quantity"));
        System.out.println(product);
      }
    } catch (SQLException e) {
      System.out.println("Error displaying all products: " + e.getMessage());
    }
  }
}