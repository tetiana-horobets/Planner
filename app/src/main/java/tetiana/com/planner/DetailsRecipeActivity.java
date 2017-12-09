package tetiana.com.planner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsRecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_recipe);

        TextView mDisplayText = (TextView) findViewById(R.id.tv_display_ingredient_recipe);
        TextView mDisplayTitle = (TextView) findViewById(R.id.tv_display);

        String title = this.getIntent().getStringExtra("title_key");
        String text = this.getIntent().getStringExtra("additional_text_key");
        mDisplayTitle.setText(title);
        mDisplayText.setText(text);
    }
}
