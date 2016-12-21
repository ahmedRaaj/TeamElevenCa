package ca.teameleven.com.teamelevenca.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import ca.teameleven.com.teamelevenca.R;
import ca.teameleven.com.teamelevenca.adapters.ItemAdapter;
import ca.teameleven.com.teamelevenca.dao.ItemDao;
import ca.teameleven.com.teamelevenca.dao.ItemDaoImpl;
import ca.teameleven.com.teamelevenca.util.DummyData;

/**
 * Created by ahmedraaj on 21/12/16.
 */

public class ItemActivity extends AppCompatActivity {
    ListView mItemsListView;
    ItemDao itemDao = new ItemDaoImpl();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        mItemsListView = (ListView) findViewById(R.id.lv_item);
        Intent intent = getIntent();
        String catId = intent.getStringExtra(CategoryActivity.CATEGORYID);
       // Toast.makeText(this,catId,Toast.LENGTH_LONG).show();
        mItemsListView.setAdapter(new ItemAdapter(this,R.layout.row_item, itemDao.getAllItems(Integer.parseInt(catId))));

    }
}
