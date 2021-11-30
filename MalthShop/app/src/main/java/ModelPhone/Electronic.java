package ModelPhone;

import java.io.Serializable;

public class Electronic implements Serializable {
    private int Id;
    private String ComponentName;
    private String ComponentImage;
    private double Price;
    private int IdType;

    public Electronic(int id, String componentName, String componentImage, double price, int idType) {
        Id = id;
        ComponentName = componentName;
        ComponentImage = componentImage;
        Price = price;
        IdType = idType;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getComponentName() {
        return ComponentName;
    }

    public void setComponentName(String componentName) {
        ComponentName = componentName;
    }

    public String getComponentImage() {
        return ComponentImage;
    }

    public void setComponentImage(String componentImage) {
        ComponentImage = componentImage;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getIdType() {
        return IdType;
    }

    public void setIdType(int idType) {
        IdType = idType;
    }
}
