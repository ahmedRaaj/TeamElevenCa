package ca.teameleven.com.teamelevenca.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import ca.teameleven.com.teamelevenca.R;
import ca.teameleven.com.teamelevenca.adapters.CategoryAdapter;
import ca.teameleven.com.teamelevenca.model.Category;
import ca.teameleven.com.teamelevenca.util.DummyData;

public class CategoryActivity extends AppCompatActivity {
    public static String CATEGORYID;

    ListView mCategoryListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        mCategoryListView = (ListView) findViewById(R.id.lv_category);

        new AsyncTask<Void, Void, List<Category>>() {
            @Override
            protected List<Category> doInBackground(Void... params) {
                return DummyData.categories;
            }

            @Override
            protected void onPostExecute(List<Category> categories) {
                mCategoryListView.setAdapter(new CategoryAdapter(CategoryActivity.this,R.layout.row_category, categories));
                mCategoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Category category = (Category) parent.getAdapter().getItem(position);
                        Intent intent = new Intent(CategoryActivity.this,ItemActivity.class);
                        intent.putExtra(CATEGORYID,String.valueOf(category.getcategoryId()));
                        startActivity(intent);
                        //Toast.makeText(CategoryActivity.this,category.getCategoryName(),Toast.LENGTH_LONG).show();
                    }
                });

            }
        }.execute();


    }

}
