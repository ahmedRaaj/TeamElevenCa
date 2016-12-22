package ca.teameleven.com.teamelevenca.dao;

import java.util.List;

import ca.teameleven.com.teamelevenca.model.Item;
import ca.teameleven.com.teamelevenca.util.JSONParser;

/**
 * Created by ahmedraaj on 21/12/16.
 */

public interface ItemDao {
    JSONParser parser = new JSONParser();
    String URL = "http://10.10.24.172/WCFT11_CA/service1.svc";
    public Item getItem(int id);
    public List<Item> getAllItems();
    public void Save(Item item);
    public void Delete(int id);
    public List<Item> getAllItems(int categoryId);
}
