package tetiana.com.planner;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import tetiana.com.planner.data.RecipeContract;
import tetiana.com.planner.data.RecipeDbHelper;


class DataBase{

    private Context context;

    public DataBase(Context context) {
        this.context = context;
    }

    private  RecipeDbHelper dbHelper = new RecipeDbHelper(context);
    SQLiteDatabase mDb = dbHelper.getWritableDatabase();

    Cursor getAllRecipes() {
        String rawQuery = "SELECT * FROM " +
                RecipeContract.RecipeLinked.TABLE_NAME +
                " INNER JOIN " + RecipeContract.TitleAndTypeOfRecipe.TABLE_NAME +
                " ON " + RecipeContract.RecipeLinked.COLUMN_ID_RECIPE + " = " + RecipeContract.TitleAndTypeOfRecipe.TABLE_NAME + "." + RecipeContract.TitleAndTypeOfRecipe._ID +
                " INNER JOIN " + RecipeContract.Ingredient.TABLE_NAME +
                " ON " + RecipeContract.RecipeLinked.COLUMN_ID_INGREDIENT + " = " + RecipeContract.Ingredient.TABLE_NAME + "." + RecipeContract.Ingredient._ID +
                " INNER JOIN " + RecipeContract.RecipeInstruction.TABLE_NAME +
                " ON " + RecipeContract.RecipeLinked.COLUMN_ID_INSTRUCTION + " = " + RecipeContract.RecipeInstruction.TABLE_NAME + "." + RecipeContract.RecipeInstruction._ID +
                " WHERE " + RecipeContract.RecipeLinked.COLUMN_ID_RECIPE + " = " +  1;

        return mDb.rawQuery(
                rawQuery,
                null
        );
    }

    public SQLiteDatabase getmDb() {
        return mDb;
    }


//    public static long addNewRecipe(String title, String type) {
//        ContentValues cv = new ContentValues();
//        cv.put(RecipeContract.TitleAndTypeOfRecipe.COLUMN_RECIPE_TITLE, title);
//        cv.put(RecipeContract.TitleAndTypeOfRecipe.COLUMN_RECIPE_TYPE, type);
//        return mDb.insert(RecipeContract.TitleAndTypeOfRecipe.TABLE_NAME, null, cv);
//    }
//
//
//    static long addNewIngredient(String ingredient) {
//        ContentValues cv = new ContentValues();
//        cv.put(RecipeContract.Ingredient.COLUMN_INGREDIENT_NAME, ingredient);
//        return mDb.insert(RecipeContract.Ingredient.TABLE_NAME, null, cv);
//    }
//
//    static long addNewRecipeInstruction(String instruction) {
//        ContentValues cv = new ContentValues();
//        cv.put(RecipeContract.RecipeInstruction.COLUMN_RECIPE_INSTRUCTION, instruction);
//        return mDb.insert(RecipeContract.RecipeInstruction.TABLE_NAME, null, cv);
//    }

}
