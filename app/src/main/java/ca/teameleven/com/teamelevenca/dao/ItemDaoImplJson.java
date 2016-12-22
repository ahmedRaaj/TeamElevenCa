package ca.teameleven.com.teamelevenca.dao;

import java.util.ArrayList;
import java.util.List;

import ca.teameleven.com.teamelevenca.model.Item;
import ca.teameleven.com.teamelevenca.util.JSONParser;

/**
 * Created by ahmedraaj on 21/12/16.
 */
public class ItemDaoImplJson implements ItemDao {
    JSONParser parser = new JSONParser();
    String URL = "http://10.10.24.172/WCFT11_CA/service1.svc";
    @Override
    public Item getItem(int id) {
        Item i = new Item();
       return null;
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> list = new ArrayList<>();


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
