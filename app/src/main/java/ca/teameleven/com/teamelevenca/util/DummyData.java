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
        categories.add(new Category(0,"Electronics"));
        categories.add(new Category(1,"Household"));
        categories.add(new Category(2,"Furniture"));

        items = new ArrayList<Item>();
        items.add(new Item(0,"Wire","electric wire",2.2,0));
        items.add(new Item(1,"TV","electric wire",2.2,0));
        items.add(new Item(2,"Cooker","electric wire",2.2,0));
        items.add(new Item(3,"Sofa","Wooden sofa",1.2,2));
        items.add(new Item(4,"Matrices","Queen size",5.2,1));
        items.add(new Item(5,"Table","Table",22.2,2));

        users = new ArrayList<>();
        users.add(new User(0,"raaj","buyer"));
        users.add(new User(1,"zoe","seller"));
        users.add(new User(2,"janaki","buyer"));

    }


}
