package ca.teameleven.com.teamelevenca.dao;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ca.teameleven.com.teamelevenca.model.Category;
import ca.teameleven.com.teamelevenca.model.Item;
import ca.teameleven.com.teamelevenca.util.JSONParser;

/**
 * Created by ahmedraaj on 21/12/16.
 */
public class ItemDaoImplJson implements ItemDao {

    @Override
    public Item getItem(int id) {
       // Item item = new Item();
        String id_str=String.valueOf(id);
        JSONObject itemJ=JSONParser.getJSONFromUrl(URL+"/GetItemsListbyId/"+id);
        try {
            Item item = getFromJson(itemJ.getString("CategoryId"),itemJ.getString("Id"), itemJ.getString("Name"),itemJ.getString("ItemsDetail"),itemJ.getString("Price"));
            return item ;
        } catch (JSONException e) {
            e.printStackTrace();
        }
       return null;
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> list = new ArrayList<>();

        JSONArray itemListJson = JSONParser.getJSONArrayFromUrl(URL + "/GetItemsList");
        try {
            for(int i = 0; i < itemListJson.length();i++){
                JSONObject itemJ = itemListJson.getJSONObject(i);

                Item item = getFromJson(itemJ.getString("CategoryId"),itemJ.getString("Id"), itemJ.getString("Name"),itemJ.getString("ItemsDetail"),itemJ.getString("Price"));
                list.add(item);
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }


        return list;
    }

    @Override
    public void Save(Item item) {

        if(item.getId() > 0) { //update call. since has the id
            StringBuilder builder = new StringBuilder();
            builder.append("{").append("\"CategoryId\"").append(":").append("\"").append(item.getCategoryId()).append("\",");
            builder.append("\"ItemsDetail\"").append(":").append("\"").append(item.getItemDesc()).append("\",");
            builder.append("\"Name\"").append(":").append("\"").append("Testing Dummy").append("\",");
            builder.append("\"Price\"").append(":").append("\"").append(item.getPrice()).append("\"");
            builder.append("}");

           JSONParser.postStream(URL+"/UpdateItems",builder.toString());
        }
        else{   //new creation call

        }

    }

    public  void Testing(String json){
        JSONParser.postStream(URL+"/UpdateItems",json);
    }


    @Override
    public void Delete(int id) {
       // JSONParser.

    }

    @Override
    public List<Item> getAllItems(int categoryId) {

        List<Item> list = new ArrayList<>();
        String id= String.valueOf(categoryId);
        JSONArray itemListJson = JSONParser.getJSONArrayFromUrl(URL + "/GetbyCategory/"+id);
        try {
            for(int i = 0; i < itemListJson.length();i++){
                JSONObject itemJ = itemListJson.getJSONObject(i);

                Item item = getFromJson(itemJ.getString("CategoryId"),itemJ.getString("Id"), itemJ.getString("Name"),itemJ.getString("ItemsDetail"),itemJ.getString("Price"));
                list.add(item);
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return list;

    }
    
    
    private Item getFromJson(String categoryId, String id, String name, String itemsDetail, String price){
        Item item = new Item(Integer.parseInt(id),name,itemsDetail,Double.parseDouble(price),Integer.parseInt(categoryId));
        return item;
    }
    
}
