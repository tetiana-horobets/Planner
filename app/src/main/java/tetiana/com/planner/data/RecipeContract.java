package tetiana.com.planner.data;


import android.provider.BaseColumns;

public class RecipeContract {

    public static final class RecipeEntry implements BaseColumns {
        public static final String TABLE_NAME = "recipeList";
        public static final String COLUMN_RECIPE_TITLE = "recipeTitle";
        public static final String COLUMN_RECIPE_TYPE = "recipeType";
    }
}
