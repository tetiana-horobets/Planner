package tetiana.com.planner;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements Adapter.ListItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mNumbersList = (RecyclerView) findViewById(R.id.rv_recipes);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mNumbersList.setLayoutManager(layoutManager);

        mNumbersList.setHasFixedSize(true);

        Adapter mAdapter = new Adapter(DataRecipe.prepareRecipeData(), this);
        mNumbersList.setAdapter(mAdapter);
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        Context context = MainActivity.this;
        Class destinationActivity = DetailsRecipeActivity.class;
        Intent startDetailsRecipeActivityIntent = new Intent(context, destinationActivity);
        startDetailsRecipeActivityIntent.putExtra("additional_text_key", DataRecipe.prepareRecipeData().get(clickedItemIndex).getIngredient().getIngredient());
        startDetailsRecipeActivityIntent.putExtra("title_key", DataRecipe.prepareRecipeData().get(clickedItemIndex).getTitle());
        startActivity(startDetailsRecipeActivityIntent);
    }
}
