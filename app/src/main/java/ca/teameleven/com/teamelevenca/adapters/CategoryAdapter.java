package ca.teameleven.com.teamelevenca.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

import ca.teameleven.com.teamelevenca.R;
import ca.teameleven.com.teamelevenca.model.Category;

/**
 * Created by ahmedraaj on 21/12/16.
 */

public class CategoryAdapter extends ArrayAdapter<Category> {
    private int resource;
    private List<Category> categories;
    public CategoryAdapter(Context context, int resource, List<Category> objects) {
        super(context, resource, objects);
        this.resource = resource;
        this.categories = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(resource, null);
        Category category = categories.get(position);
        if(category != null){
            TextView mCategoryNameTV = (TextView) view.findViewById(R.id.tv_category);
            mCategoryNameTV.setText(category.getCategoryName());
        }
        return view;
    }
}
