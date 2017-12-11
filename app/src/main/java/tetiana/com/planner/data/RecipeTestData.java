package tetiana.com.planner.data;


import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class RecipeTestData {

    public static void insertFakeData(SQLiteDatabase db) {
        if (db == null) {
            return;
        }

        List<ContentValues> recipeDataList = new ArrayList<ContentValues>();

        ContentValues cv = new ContentValues();
        cv.put(RecipeContract.RecipeEntry.COLUMN_RECIPE_TITLE, "Berry and Yogurt Smoothie");
        cv.put(RecipeContract.RecipeEntry.COLUMN_RECIPE_TYPE, "breakfast");
        recipeDataList.add(cv);

        cv = new ContentValues();
        cv.put(RecipeContract.RecipeEntry.COLUMN_RECIPE_TITLE, "Sunny-Side Up Fried Eggs");
        cv.put(RecipeContract.RecipeEntry.COLUMN_RECIPE_TYPE, "breakfast");
        recipeDataList.add(cv);

        cv = new ContentValues();
        cv.put(RecipeContract.RecipeEntry.COLUMN_RECIPE_TITLE, "Chicken");
        cv.put(RecipeContract.RecipeEntry.COLUMN_RECIPE_TYPE, "diner");
        recipeDataList.add(cv);

        cv = new ContentValues();
        cv.put(RecipeContract.RecipeEntry.COLUMN_RECIPE_TITLE, "Sous");
        cv.put(RecipeContract.RecipeEntry.COLUMN_RECIPE_TYPE, "sous");
        recipeDataList.add(cv);

        try
        {
            db.beginTransaction();
            //clear the table first
            db.delete (RecipeContract.RecipeEntry.TABLE_NAME,null,null);
            //go through the list and add one by one
            for(ContentValues c:recipeDataList){
                db.insert(RecipeContract.RecipeEntry.TABLE_NAME, null, c);
            }
            db.setTransactionSuccessful();
        }
        catch (SQLException e) {
            //too bad :(
        }
        finally
        {
            db.endTransaction();
        }
    }
}
