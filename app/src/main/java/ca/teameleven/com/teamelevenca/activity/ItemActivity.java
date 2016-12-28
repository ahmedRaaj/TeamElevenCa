package ca.teameleven.com.teamelevenca.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ca.teameleven.com.teamelevenca.R;
import ca.teameleven.com.teamelevenca.adapters.ItemAdapter;
import ca.teameleven.com.teamelevenca.dao.ItemDao;
import ca.teameleven.com.teamelevenca.dao.ItemDaoImpl;
import ca.teameleven.com.teamelevenca.dao.ItemDaoImplJson;
import ca.teameleven.com.teamelevenca.model.Item;
import ca.teameleven.com.teamelevenca.util.DummyData;

/**
 * Created by ahmedraaj on 21/12/16.
 */

public class ItemActivity extends Activity {
    ListView mItemsListView;
    ItemDao itemDao ;
    public static String ITEMID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        mItemsListView = (ListView) findViewById(R.id.lv_item);
        Intent intent = getIntent();
        String catId = intent.getStringExtra(CategoryActivity.CATEGORYID);
       // Toast.makeText(this,catId,Toast.LENGTH_LONG).show();



        new AsyncTask<String,Void,List<Item>>(){

            @Override
            protected List<Item> doInBackground(String... params) {
               String catId = params[0];
                itemDao = new ItemDaoImplJson();

                return itemDao.getAllItems(Integer.parseInt(catId));
            }

            @Override
            protected void onPostExecute(List<Item> items) {
                mItemsListView.setAdapter(new ItemAdapter(ItemActivity.this,R.layout.row_item,items));
                mItemsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        TextView idTv = (TextView)view.findViewById(R.id.tv_itemIdHidden);
                        int itemId = Integer.parseInt(idTv.getText().toString());
                     // Toast.makeText(ItemActivity.this,"Before id: "+itemId , Toast.LENGTH_SHORT).show();

                        Intent detailsIntent = new Intent(ItemActivity.this,ItemDetailActivity.class);
                        detailsIntent.putExtra("itemId",String.valueOf(itemId));

                        startActivityForResult(detailsIntent,2);
                    }
                });

            }
        }.execute(catId);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent = new Intent(this,InsertActivity.class);
        startActivity(intent);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Log.i("Loggingggg: ","came back");

        super.onActivityResult(requestCode, resultCode, data);
        recreate();
    }
}
