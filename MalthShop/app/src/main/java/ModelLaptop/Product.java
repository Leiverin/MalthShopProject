package ModelLaptop;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String productName;
    private String brand;
    private double price;
    private int status;
    private String description;
    private String imageProduct;
    private int idType;

    public Product(int id, String productName, String brand, double price, int status, String description, String imageProduct, int idType) {
        this.id = id;
        this.productName = productName;
        this.brand = brand;
        this.price = price;
        this.status = status;
        this.description = description;
        this.imageProduct = imageProduct;
        this.idType = idType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(String imageProduct) {
        this.imageProduct = imageProduct;
    }
}
