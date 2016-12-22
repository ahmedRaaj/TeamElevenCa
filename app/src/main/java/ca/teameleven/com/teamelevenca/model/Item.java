package ca.teameleven.com.teamelevenca.model;

/**
 * Created by ahmedraaj on 21/12/16.
 */

public class Item {
    private int id;
    private String itemName;
    private String itemDesc;
    private double price;
    private int categoryId;

    public Item(int id, String itemName, String itemDesc, double price, int categoryId) {
        this.id = id;
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.price = price;
        this.categoryId = categoryId;
    }

    public Item(){}

    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
