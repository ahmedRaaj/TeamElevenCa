package ca.teameleven.com.teamelevenca.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import ca.teameleven.com.teamelevenca.R;
import ca.teameleven.com.teamelevenca.adapters.ItemAdapter;
import ca.teameleven.com.teamelevenca.dao.ItemDao;
import ca.teameleven.com.teamelevenca.dao.ItemDaoImpl;
import ca.teameleven.com.teamelevenca.model.Item;
import ca.teameleven.com.teamelevenca.util.DummyData;

/**
 * Created by ahmedraaj on 21/12/16.
 */

public class ItemActivity extends AppCompatActivity {
    ListView mItemsListView;
    ItemDao itemDao = new ItemDaoImpl();
    public static String ITEMID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        mItemsListView = (ListView) findViewById(R.id.lv_item);
        Intent intent = getIntent();
        String catId = intent.getStringExtra(CategoryActivity.CATEGORYID);
       // Toast.makeText(this,catId,Toast.LENGTH_LONG).show();
        mItemsListView.setAdapter(new ItemAdapter(this,R.layout.row_item, itemDao.getAllItems(Integer.parseInt(catId))));

        mItemsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item item = (Item) parent.getAdapter().getItem(position);
                Intent detailsIntent = new Intent(ItemActivity.this,ItemDetailActivity.class);
                detailsIntent.putExtra(ITEMID,String.valueOf(item.getId()));
                startActivity(detailsIntent);
            }
        });
    }
}
