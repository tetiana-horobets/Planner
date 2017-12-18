package tetiana.com.planner.data;


import android.provider.BaseColumns;

public class RecipeContract {

    public static final class TitleAndTypeOfRecipe implements BaseColumns {
        public static final String TABLE_NAME = "recipeList";
        public static final String COLUMN_RECIPE_TITLE = "recipeTitle";
        public static final String COLUMN_RECIPE_TYPE = "recipeType";
    }

    public static final class RecipeIngredient implements BaseColumns {
        public static final String TABLE_NAME = "recipeIngredient";
        public static final String COLUMN_INGREDIENT_NAME = "IngredientName";
    }

    public static final class RecipeInstruction implements BaseColumns {
        public static final String TABLE_NAME = "recipeIngstruction";
        public static final String COLUMN_RECIPE_INSTRUCTION = "recipeInstruction";

    }

    public static final class RecipeLinked {
        public static final String TABLE_NAME = "RecipeLinkedTable";
        public static final String COLUMN_ID_RECIPE = "idRecipeList";
        public static final String COLUMN_ID_INGREDIENT = "idIngredient";
        public static final String COLUMN_ID_INSTRUCTION = "idInstruction";
    }
}
