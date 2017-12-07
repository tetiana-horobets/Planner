package tetiana.com.planner;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Adapter.ListItemClickListener{

    private List<ShowRecipes> recipesList = new ArrayList<>();

    private Adapter mAdapter;
    private RecyclerView mNumbersList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNumbersList = (RecyclerView) findViewById(R.id.rv_recipes);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mNumbersList.setLayoutManager(layoutManager);

        mNumbersList.setHasFixedSize(true);

        mAdapter = new Adapter(recipesList, this);
        mNumbersList.setAdapter(mAdapter);
        prepareRecipeData();

    }

    private void prepareRecipeData() {
        ShowRecipes recipe = new ShowRecipes("Sunny-Side Up Fried Eggs", "breakfast");
        recipesList.add(recipe);

        recipe = new ShowRecipes("Berry and Yogurt Smoothie", "breakfast");
        recipesList.add(recipe);

        recipe = new ShowRecipes("Chicken", "diner");
        recipesList.add(recipe);

        recipe = new ShowRecipes("Shou chicken", "diner");
        recipesList.add(recipe);

        mAdapter.notifyDataSetChanged();
    }



    @Override
    public void onListItemClick(int clickedItemIndex) {
        Context context = MainActivity.this;
        Class destinationActivity = DetailsRecipeActivity.class;
        Intent startDetailsRecipeActivityIntent = new Intent(context, destinationActivity);
        startActivity(startDetailsRecipeActivityIntent);
    }
}
