package tetiana.com.planner;

import android.content.Context;
import android.content.Intent;
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


public class MainActivity extends AppCompatActivity implements Adapter.ListItemClickListener {

    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mNumbersList = (RecyclerView) findViewById(R.id.rv_recipes);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mNumbersList.setLayoutManager(layoutManager);

        RecipeDbHelper dbHelper = new RecipeDbHelper(this);
        SQLiteDatabase mDb = dbHelper.getWritableDatabase();

        RecipeTestData.insertFakeData(mDb);

        String rawQuery = "SELECT * FROM " +
                RecipeContract.RecipeLinked.TABLE_NAME +
                " INNER JOIN " + RecipeContract.TitleAndTypeOfRecipe.TABLE_NAME +
                " ON " + RecipeContract.RecipeLinked.COLUMN_ID_RECIPE + " = " + RecipeContract.TitleAndTypeOfRecipe.TABLE_NAME + "." + RecipeContract.TitleAndTypeOfRecipe._ID +
                " INNER JOIN " + RecipeContract.Ingredient.TABLE_NAME +
                " ON " + RecipeContract.RecipeLinked.COLUMN_ID_INGREDIENT + " = " + RecipeContract.Ingredient.TABLE_NAME + "." + RecipeContract.Ingredient._ID +
                " INNER JOIN " + RecipeContract.RecipeInstruction.TABLE_NAME +
                " ON " + RecipeContract.RecipeLinked.COLUMN_ID_INSTRUCTION + " = " + RecipeContract.RecipeInstruction.TABLE_NAME + "." + RecipeContract.RecipeInstruction._ID +
                " WHERE " + RecipeContract.RecipeLinked.COLUMN_ID_RECIPE + " = " +  1;

        cursor = mDb.rawQuery(
                rawQuery,
                null
        );

        Adapter mAdapter = new Adapter(this, cursor, this);

        mNumbersList.setAdapter(mAdapter);
    }

    public void addToWaitlist(View view) {

    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        Context context = MainActivity.this;
        Class destinationActivity = DetailsRecipeActivity.class;
        Intent startDetailsRecipeActivityIntent = new Intent(context, destinationActivity);
        startDetailsRecipeActivityIntent.putExtra("additional_text_key", cursor.getString(cursor.getColumnIndex(RecipeContract.Ingredient.COLUMN_INGREDIENT_NAME)));
        startDetailsRecipeActivityIntent.putExtra("title_key", cursor.getString(cursor.getColumnIndex(RecipeContract.RecipeInstruction.COLUMN_RECIPE_INSTRUCTION)));
        startActivity(startDetailsRecipeActivityIntent);
    }
}
