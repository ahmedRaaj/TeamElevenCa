package ca.teameleven.com.teamelevenca.model;

/**
 * Created by ahmedraaj on 21/12/16.
 */

public class Category {
    private int categoryId;
    private String categoryName;

    public int getcategoryId() {
        return categoryId;

    }

    public Category(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
