package ca.teameleven.com.teamelevenca.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ca.teameleven.com.teamelevenca.R;
import ca.teameleven.com.teamelevenca.dao.ItemDao;
import ca.teameleven.com.teamelevenca.dao.ItemDaoImpl;
import ca.teameleven.com.teamelevenca.model.Item;

public class ItemDetailActivity extends AppCompatActivity {
    ItemDao itemDao = new ItemDaoImpl();
    Item item;

    EditText mItemNameEditText,mItemDetailsEditText,mItemPriceEditText;
    Button mModifyButton,mDeleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        Intent intent = getIntent();
        if(intent != null){
             mItemNameEditText = (EditText) findViewById(R.id.et_detail_name);
             mItemDetailsEditText = (EditText) findViewById(R.id.et_detail_description);
             mItemPriceEditText = (EditText) findViewById(R.id.et_detail_price);
             mModifyButton = (Button) findViewById(R.id.btn_detail_modify);
             mDeleteButton = (Button) findViewById(R.id.btn_detail_delete);
             String itemId = intent.getStringExtra(ItemActivity.ITEMID);
             item = itemDao.getItem(Integer.parseInt(itemId));
             mItemDetailsEditText.setText(item.getItemDesc());
             mItemNameEditText.setText(item.getItemName());
             mItemPriceEditText.setText(String.valueOf(item.getPrice()));

             mModifyButton.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
//                     item.setItemName(mItemNameEditText.getText().toString());
//                     item.setItemDesc(mItemDetailsEditText.getText().toString());
//                     item.setPrice(Double.parseDouble(mItemPriceEditText.getText().toString()));
//                     itemDao.Save(item);
                 }
             });
        }
    }
}
