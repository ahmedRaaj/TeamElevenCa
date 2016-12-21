package ca.teameleven.com.teamelevenca.dao;

import java.util.List;

import ca.teameleven.com.teamelevenca.model.Item;

/**
 * Created by ahmedraaj on 21/12/16.
 */

public interface ItemDao {
    public Item getItem(int id);
    public List<Item> getAllItems();
    public void Save(Item item);
    public void Delete(int id);
    public List<Item> getAllItems(int categoryId);
}
