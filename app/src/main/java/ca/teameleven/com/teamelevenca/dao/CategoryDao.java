package ca.teameleven.com.teamelevenca.dao;

import java.util.List;

import ca.teameleven.com.teamelevenca.model.Category;
import ca.teameleven.com.teamelevenca.util.JSONParser;

/**
 * Created by ahmedraaj on 21/12/16.
 */

public interface CategoryDao {
    JSONParser parser = new JSONParser();
    String URL = "http://10.10.24.172/WCFT11_CA/service1.svc";
    public Category getCategory(int id);
    public List<Category> getAllCategories();
    public void Save(Category cat);
    public void Delete(int id);
}
