package ca.teameleven.com.teamelevenca.dao;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ca.teameleven.com.teamelevenca.model.Category;
import ca.teameleven.com.teamelevenca.util.JSONParser;

/**
 * Created by ahmedraaj on 22/12/16.
 */
public class CategoryDaoImplJson implements CategoryDao {
    @Override
    public Category getCategory(int id) {
       // JSONParser.getJSONFromUrl(URL+/)
        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> cList = new ArrayList<>();
        JSONArray catListJson = JSONParser.getJSONArrayFromUrl(URL + "/GetcategoryList");
        try {
            for(int i = 0; i < catListJson.length();i++){
                JSONObject cat = catListJson.getJSONObject(i);

                Category c = getFromJson(cat.getString("Id"), cat.getString("Name"));
                cList.add(c);
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return cList;
    }

    @Override
    public void Save(Category cat) {

    }

    @Override
    public void Delete(int id) {

    }

    private Category getFromJson(String id, String name){
        Category c = new Category(Integer.parseInt(id),name);
        return c;
    }

}
