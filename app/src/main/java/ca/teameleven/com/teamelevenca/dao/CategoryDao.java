package ca.teameleven.com.teamelevenca.dao;

import java.util.List;

import ca.teameleven.com.teamelevenca.model.Category;

/**
 * Created by ahmedraaj on 21/12/16.
 */

public interface CategoryDao {
    public Category getCategory(int id);
    public List<Category> getAllCategories();
    public void Save(Category cat);
    public void Delete(int id);
}
