package ca.teameleven.com.teamelevenca.dao;

import java.util.List;

import ca.teameleven.com.teamelevenca.model.Category;
import ca.teameleven.com.teamelevenca.util.DummyData;

/**
 * Created by ahmedraaj on 21/12/16.
 */
public class CategoryDaoImpl implements CategoryDao {
    @Override
    public Category getCategory(int id) {
        return DummyData.categories.get(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return DummyData.categories;
    }

    @Override
    public void Save(Category cat) {

        DummyData.categories.add(cat);
    }

    @Override
    public void Delete(int id) {

        DummyData.categories.remove(id);
    }
}
