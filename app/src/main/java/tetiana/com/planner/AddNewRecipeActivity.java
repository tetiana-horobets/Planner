package tetiana.com.planner;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class AddNewRecipeActivity extends AppCompatActivity {

    EditText mNewTitleRecipEditText = (EditText) findViewById(R.id.et_write_recipe_title);
    EditText mNewTypeRecipEditText = (EditText) findViewById(R.id.et_write_recipe_type);
    EditText mNewIngredientRecipEditText = (EditText) findViewById(R.id.et_write_recipe_ingredient);
    EditText mNewInstructionRecipEditText = (EditText) findViewById(R.id.et_write_recipe_instruction);

    Button saveNewRecipe = (Button) findViewById(R.id.b_save_new_recipe);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_recipe);
    }

//    public void newRecipe(View view) {
//
//        if (mNewTitleRecipEditText.getText().length() == 0 ||
//                mNewTypeRecipEditText.getText().length() == 0 ||
//                mNewIngredientRecipEditText.getText().length() == 0 ||
//                mNewInstructionRecipEditText.getText().length() == 0)
//        {
//            return;
//        }
//
//        DataBase.addNewRecipe(mNewTitleRecipEditText.getText().toString(), mNewTypeRecipEditText.getText().toString());
//        DataBase.addNewIngredient(mNewIngredientRecipEditText.getText().toString());
//        DataBase.addNewRecipeInstruction(mNewInstructionRecipEditText.getText().toString());
//
//        MainActivity.mAdapter.swapCursor(DataBase.getAllRecipes());
//
//        mNewTitleRecipEditText.clearFocus();
//        mNewTypeRecipEditText.clearFocus();
//        mNewIngredientRecipEditText.clearFocus();
//        mNewInstructionRecipEditText.clearFocus();
//
//        mNewTitleRecipEditText.getText().clear();
//        mNewTypeRecipEditText.getText().clear();
//        mNewIngredientRecipEditText.getText().clear();
//        mNewInstructionRecipEditText.getText().clear();
//    }
}
