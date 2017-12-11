package tetiana.com.planner;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import tetiana.com.planner.data.RecipeContract;
import tetiana.com.planner.data.RecipeDbHelper;
import tetiana.com.planner.data.RecipeTestData;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase mDb;
    private Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mNumbersList = (RecyclerView) findViewById(R.id.rv_recipes);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mNumbersList.setLayoutManager(layoutManager);

        RecipeDbHelper dbHelper = new RecipeDbHelper(this);
        mDb = dbHelper.getWritableDatabase();

        RecipeTestData.insertFakeData(mDb);

        Cursor cursor = getAllRecipes();
        mAdapter = new Adapter(this, cursor);

        mNumbersList.setAdapter(mAdapter);
    }

    public void addToWaitlist(View view) {

    }

    private Cursor getAllRecipes() {
        return mDb.query(
                RecipeContract.RecipeEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }
}
