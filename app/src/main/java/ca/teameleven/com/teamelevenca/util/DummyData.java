package ca.teameleven.com.teamelevenca.util;

import java.util.ArrayList;
import java.util.List;

import ca.teameleven.com.teamelevenca.model.Category;
import ca.teameleven.com.teamelevenca.model.Item;
import ca.teameleven.com.teamelevenca.model.User;

/**
 * Created by ahmedraaj on 21/12/16.
 */

public class DummyData {
    public static List<Category> categories;
    public static List<Item> items;
    public static List<User> users;

    static {
        categories = new ArrayList<Category>();
        categories.add(new Category(1,"Electronics"));
        categories.add(new Category(2,"Household"));
        categories.add(new Category(3,"Furniture"));

        items = new ArrayList<Item>();
        items.add(new Item(1,"Wire","electric wire",2.2,1));
        items.add(new Item(2,"TV","electric wire",2.2,1));
        items.add(new Item(3,"Cooker","electric wire",2.2,1));
        items.add(new Item(4,"Sofa","Wooden sofa",1.2,3));
        items.add(new Item(5,"Matrices","Queen size",5.2,2));
        items.add(new Item(6,"Table","Table",22.2,3));

        users = new ArrayList<>();
        users.add(new User(1,"raaj","buyer"));
        users.add(new User(2,"zoe","seller"));
        users.add(new User(3,"janaki","buyer"));

    }


}
