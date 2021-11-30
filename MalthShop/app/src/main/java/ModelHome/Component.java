package ModelHome;

import java.io.Serializable;

public class Component implements Serializable {
    private int id;
    private String componentName;
    private String componentImage;
    private int status;
    private double price;
    private int type;

    public Component(int id, String componentName, String componentImage, int status, double price,  int type) {
        this.id = id;
        this.componentName = componentName;
        this.componentImage = componentImage;
        this.status = status;
        this.price = price;
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getComponentImage() {
        return componentImage;
    }

    public void setComponentImage(String componentImage) {
        this.componentImage = componentImage;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
