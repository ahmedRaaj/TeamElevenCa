package ca.teameleven.com.teamelevenca.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import ca.teameleven.com.teamelevenca.R;
import ca.teameleven.com.teamelevenca.dao.ItemDao;
import ca.teameleven.com.teamelevenca.dao.ItemDaoImpl;
import ca.teameleven.com.teamelevenca.dao.ItemDaoImplJson;
import ca.teameleven.com.teamelevenca.model.Item;

public class ItemDetailActivity extends AppCompatActivity {
    ItemDao itemDao ;


    Item item;

    EditText mItemNameEditText,mItemDetailsEditText,mItemPriceEditText,mItemIdET;
    Button mModifyButton,mDeleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        final Intent intent = getIntent();
        if(intent != null){
             mItemNameEditText = (EditText) findViewById(R.id.et_detail_name);
             mItemDetailsEditText = (EditText) findViewById(R.id.et_detail_description);
             mItemPriceEditText = (EditText) findViewById(R.id.et_detail_price);
             mItemIdET = (EditText) findViewById(R.id.et_item_id);
            mModifyButton = (Button) findViewById(R.id.btn_detail_modify);
             mDeleteButton = (Button) findViewById(R.id.btn_detail_delete);
             String itemId = intent.getStringExtra("itemId");
            //Toast.makeText(ItemDetailActivity.this,"id: "+itemId + " Real item id"+item.getId(), Toast.LENGTH_LONG).show();

            new AsyncTask<String, Void, Item>() {
                @Override
                protected Item doInBackground(String... params) {
                 ItemDao   itemDao = new ItemDaoImplJson();
                    String itemId = params[0];
                    item =  itemDao.getItem(Integer.parseInt(itemId));
                    return  item;
                }

                @Override
                protected void onPostExecute(Item i) {
                    mItemDetailsEditText.setText(i.getItemDesc());
                    mItemNameEditText.setText(i.getItemName());
                    mItemPriceEditText.setText(String.valueOf(i.getPrice()));
                    mItemIdET.setText(String.valueOf(i.getId()));

                    mModifyButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            item.setItemName(mItemNameEditText.getText().toString());
                            item.setItemDesc(mItemDetailsEditText.getText().toString());
                            item.setPrice(Double.parseDouble(mItemPriceEditText.getText().toString()));
                            item.setId(Integer.parseInt(mItemIdET.getText().toString()));

                            new AsyncTask<Void,Void,Void>(){

                                @Override
                                protected Void doInBackground(Void... params) {
                                 //  itemDao.Save(item);
                                  //  Toast.makeText(ItemDetailActivity.this,"DD",Toast.LENGTH_LONG).show();
                                    return null;
                                }

                                @Override
                                protected void onPostExecute(Void aVoid) {
                                    finish();
                                }
                            }.execute(); //for updating item
                        }
                    });

                    mDeleteButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(ItemDetailActivity.this,item.getId() + "", Toast.LENGTH_LONG).show();
                            new AsyncTask<Void,Void,Void>(){

                                @Override
                                protected Void doInBackground(Void... params) {
                                  //  itemDao.Delete(item.getId());
                                    return  null;
                                }

                                @Override
                                protected void onPostExecute(Void aVoid) {
                                    finish();
                                }
                            }.execute();
                        }
                    });
                }
            }.execute(itemId);

        }



    }
}
