package ModelPhone;

import java.io.Serializable;

public class Product implements Serializable {
    private int Id;
    private String ProductName;
    private String Brand;
    private double Price;
    private int Status;
    private String Description;
    private String Picture;
    private int IdType;

    public Product(int id, String productName, String brand, double price, int status, String description, String picture, int idType) {
        Id = id;
        ProductName = productName;
        Brand = brand;
        Price = price;
        Status = status;
        Description = description;
        Picture = picture;
        IdType = idType;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    public int getIdType() {
        return IdType;
    }

    public void setIdType(int idType) {
        IdType = idType;
    }
}
