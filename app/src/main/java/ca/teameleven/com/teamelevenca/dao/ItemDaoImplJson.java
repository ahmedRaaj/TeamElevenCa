package ca.teameleven.com.teamelevenca.dao;

import java.util.List;

import ca.teameleven.com.teamelevenca.model.Item;
import ca.teameleven.com.teamelevenca.util.JSONParser;

/**
 * Created by ahmedraaj on 21/12/16.
 */
public class ItemDaoImplJson implements ItemDao {
    JSONParser parser = new JSONParser();
    String URL = null;
    @Override
    public Item getItem(int id) {
        return null;
    }

    @Override
    public List<Item> getAllItems() {
        return null;
    }

    @Override
    public void Save(Item item) {

    }

    @Override
    public void Delete(int id) {

    }

    @Override
    public List<Item> getAllItems(int categoryId) {
        return null;
    }
}
