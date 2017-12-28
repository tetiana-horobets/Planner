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
import android.widget.Button;

import tetiana.com.planner.data.RecipeContract;
import tetiana.com.planner.data.RecipeTestData;


public class MainActivity extends AppCompatActivity implements Adapter.ListItemClickListener {

    Adapter mAdapter;
    Cursor cursor;
    DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        dataBase = new DataBase(this);

        RecyclerView mNumbersList = (RecyclerView) findViewById(R.id.rv_recipes);
        Button saveNewRecipe = (Button) findViewById(R.id.add_new_recipe);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mNumbersList.setLayoutManager(layoutManager);
        RecipeTestData.insertFakeData(dataBase.getmDb());
        cursor = dataBase.getAllRecipes();
        mAdapter = new Adapter(this, cursor, this);

        mNumbersList.setAdapter(mAdapter);

        saveNewRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startAddNewActivity = new Intent(MainActivity.this, AddNewRecipeActivity.class);
                startActivity(startAddNewActivity);
            }
        });
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
