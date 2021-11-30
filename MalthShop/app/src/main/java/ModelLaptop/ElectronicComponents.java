package ModelLaptop;

import java.io.Serializable;

public class ElectronicComponents implements Serializable {
    private String componentImage;
    private String componentName;
    private int Id;
    private int IdType;
    private double price;
    private int status;

    public ElectronicComponents(String componentImage, String componentName, int id, int idType, double price, int status) {
        this.componentImage = componentImage;
        this.componentName = componentName;
        Id = id;
        IdType = idType;
        this.price = price;
        this.status = status;
    }

    public String getComponentImage() {
        return componentImage;
    }

    public void setComponentImage(String componentImage) {
        this.componentImage = componentImage;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getIdType() {
        return IdType;
    }

    public void setIdType(int idType) {
        IdType = idType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
