package tetiana.com.planner.data;


import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class RecipeTestData {

    public static void insertFakeData(SQLiteDatabase db) {
        if (db == null) {
            return;
        }

        try {
            db.beginTransaction();
            db.delete(RecipeContract.TitleAndTypeOfRecipe.TABLE_NAME, null, null);
            db.delete(RecipeContract.Ingredient.TABLE_NAME, null, null);
            db.delete(RecipeContract.RecipeInstruction.TABLE_NAME, null, null);
            db.delete(RecipeContract.RecipeLinked.TABLE_NAME, null, null);
            
            ContentValues titleAndTypeOfRecipeValues = new ContentValues();
            titleAndTypeOfRecipeValues.put(RecipeContract.TitleAndTypeOfRecipe.COLUMN_RECIPE_TITLE, "Berry and Yogurt Smoothie");
            titleAndTypeOfRecipeValues.put(RecipeContract.TitleAndTypeOfRecipe.COLUMN_RECIPE_TYPE, "Breakfast");
            db.insert(RecipeContract.TitleAndTypeOfRecipe.TABLE_NAME, null, titleAndTypeOfRecipeValues);

            ContentValues recipeIngredientValues = new ContentValues();
            recipeIngredientValues.put(RecipeContract.Ingredient.COLUMN_INGREDIENT_NAME, "Onion");
            db.insert(RecipeContract.Ingredient.TABLE_NAME, null, recipeIngredientValues);

            ContentValues recipeInstructionValues = new ContentValues();
            recipeInstructionValues.put(RecipeContract.RecipeInstruction.COLUMN_RECIPE_INSTRUCTION, "Smoothie instruction");
            db.insert(RecipeContract.RecipeInstruction.TABLE_NAME, null, recipeInstructionValues);

            ContentValues recipeLinkedValues = new ContentValues();
            recipeLinkedValues.put(RecipeContract.RecipeLinked.COLUMN_ID_RECIPE, 1);
            recipeLinkedValues.put(RecipeContract.RecipeLinked.COLUMN_ID_INSTRUCTION, 1);
            recipeLinkedValues.put(RecipeContract.RecipeLinked.COLUMN_ID_INGREDIENT, 1);
            db.insert(RecipeContract.RecipeLinked.TABLE_NAME, null, recipeLinkedValues);

            db.setTransactionSuccessful();
        } catch (SQLException e) {
        } finally {
            db.endTransaction();
        }
    }
}
