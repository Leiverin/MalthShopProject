package ModelLaptop;

import java.io.Serializable;

public class Mouse implements Serializable {
    private int id;
    private String mouseDescription;
    private String mouseImage;
    private String mouseName;
    private double mousePrice;
    private int mouseStatus;

    public Mouse(int id, String mouseDescription, String mouseImage, String mouseName, double mousePrice, int mouseStatus) {
        this.id = id;
        this.mouseDescription = mouseDescription;
        this.mouseImage = mouseImage;
        this.mouseName = mouseName;
        this.mousePrice = mousePrice;
        this.mouseStatus = mouseStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMouseDescription() {
        return mouseDescription;
    }

    public void setMouseDescription(String mouseDescription) {
        this.mouseDescription = mouseDescription;
    }

    public String getMouseImage() {
        return mouseImage;
    }

    public void setMouseImage(String mouseImage) {
        this.mouseImage = mouseImage;
    }

    public double getMousePrice() {
        return mousePrice;
    }

    public void setMousePrice(double mousePrice) {
        this.mousePrice = mousePrice;
    }

    public int getMouseStatus() {
        return mouseStatus;
    }

    public void setMouseStatus(int mouseStatus) {
        this.mouseStatus = mouseStatus;
    }

    public String getMouseName() {
        return mouseName;
    }

    public void setMouseName(String mouseName) {
        this.mouseName = mouseName;
    }
}
