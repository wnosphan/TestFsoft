
package model;

public class Product {
  private String id;
  private String name;
  private double unitPrice;
  private int quantity;
  private String status;

  public Product(String id, String name, double unitPrice, int quantity, String status) {
    this.id = id;
    this.name = name;
    this.unitPrice = unitPrice;
    this.quantity = quantity;
    this.status = status;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(double unitPrice) {
    this.unitPrice = unitPrice;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}