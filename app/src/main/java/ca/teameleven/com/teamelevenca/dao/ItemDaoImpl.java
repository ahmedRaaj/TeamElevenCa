package ca.teameleven.com.teamelevenca.dao;

import java.util.ArrayList;
import java.util.List;

import ca.teameleven.com.teamelevenca.model.Item;
import ca.teameleven.com.teamelevenca.util.DummyData;

/**
 * Created by ahmedraaj on 21/12/16.
 */
public class ItemDaoImpl implements ItemDao {
    @Override
    public Item getItem(int id) {
        return DummyData.items.get(id);
    }

    @Override
    public List<Item> getAllItems() {
        return DummyData.items;
    }

    @Override
    public void Save(Item item) {

        DummyData.items.add(item);
    }

    @Override
    public void Delete(int id) {
        DummyData.items.remove(id);
    }

    @Override
    public List<Item> getAllItems( int categoryId) {
        List<Item> items = new ArrayList<>();
       for(Item i : DummyData.items){
           if(i.getCategoryId() == categoryId)
               items.add(i);
       }
        return items;
    }
}
