package ModelHome;

import java.io.Serializable;

public class SpecialProduct implements Serializable {
    private int id;
    private String img;
    private double percentSale;
    private double price;
    private int status;
    private String productName;
    private String description;

    public SpecialProduct(int id, String img, double percentSale, double price, int status, String productName, String description) {
        this.id = id;
        this.img = img;
        this.percentSale = percentSale;
        this.price = price;
        this.status = status;
        this.productName = productName;
        this.description = description;
    }

    public double getPercentSale() {
        return percentSale;
    }

    public void setPercentSale(double percentSale) {
        this.percentSale = percentSale;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getSale() {
        return percentSale;
    }

    public void setSale(double percentSale) {
        this.percentSale = percentSale;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
