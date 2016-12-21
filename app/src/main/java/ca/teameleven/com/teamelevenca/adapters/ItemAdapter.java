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

import ca.teameleven.com.teamelevenca.R;
import ca.teameleven.com.teamelevenca.model.Category;
import ca.teameleven.com.teamelevenca.model.Item;

/**
 * Created by ahmedraaj on 21/12/16.
 */

public class ItemAdapter extends ArrayAdapter<Item> {

    private int resource;
    private List<Item> items;
    public ItemAdapter(Context context, int resource, List<Item> objects) {
        super(context, resource, objects);
        this.resource = resource;
        this.items = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(resource, null);
        Item item = items.get(position);
        if(item != null){
            TextView mCategoryNameTV = (TextView) view.findViewById(R.id.tv_item);
            mCategoryNameTV.setText(item.getItemName());
        }
        return view;
    }
}
