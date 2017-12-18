package tetiana.com.planner.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class RecipeDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "recipeList.db";

    private static final int DATABASE_VERSION = 1;

    public RecipeDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        final String SQL_CREATE_RECIPE_TABLE = "CREATE TABLE " + RecipeContract.TitleAndTypeOfRecipe.TABLE_NAME + " (" +
                RecipeContract.TitleAndTypeOfRecipe._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                RecipeContract.TitleAndTypeOfRecipe.COLUMN_RECIPE_TITLE + " TEXT NOT NULL, " +
                RecipeContract.TitleAndTypeOfRecipe.COLUMN_RECIPE_TYPE + " TEXT NOT NULL " +
                "); ";

        sqLiteDatabase.execSQL(SQL_CREATE_RECIPE_TABLE);

        final String SQL_CREATE_INGREDIENT_TABLE = "CREATE TABLE " + RecipeContract.RecipeIngredient.TABLE_NAME + " (" +
                RecipeContract.RecipeIngredient._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                RecipeContract.RecipeIngredient.COLUMN_INGREDIENT_NAME + " TEXT NOT NULL " +
                "); ";

        sqLiteDatabase.execSQL(SQL_CREATE_INGREDIENT_TABLE);

        final String SQL_CREATE_INSTRUCTION_TABLE = "CREATE TABLE " + RecipeContract.RecipeInstruction.TABLE_NAME + " (" +
                RecipeContract.RecipeInstruction._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                RecipeContract.RecipeInstruction.COLUMN_RECIPE_INSTRUCTION + " TEXT NOT NULL " +
                ");";

        sqLiteDatabase.execSQL(SQL_CREATE_INSTRUCTION_TABLE);

        final String SQL_CREATE_RECIPE_LINKED_TABLE = "CREATE TABLE " + RecipeContract.RecipeLinked.TABLE_NAME + " (" +
                RecipeContract.RecipeLinked.COLUMN_ID_RECIPE + " INTEGER, " +
                RecipeContract.RecipeLinked.COLUMN_ID_INGREDIENT + " INTEGER, " +
                RecipeContract.RecipeLinked.COLUMN_ID_INSTRUCTION + " INTEGER, " +
                " FOREIGN KEY ("+RecipeContract.RecipeLinked.COLUMN_ID_RECIPE+") REFERENCES "+
                RecipeContract.TitleAndTypeOfRecipe.TABLE_NAME+"("+RecipeContract.TitleAndTypeOfRecipe._ID+"), " +
                " FOREIGN KEY ("+RecipeContract.RecipeLinked.COLUMN_ID_INGREDIENT+") REFERENCES "+
                RecipeContract.RecipeIngredient.TABLE_NAME+"("+RecipeContract.RecipeIngredient._ID+"), " +
                " FOREIGN KEY ("+RecipeContract.RecipeLinked.COLUMN_ID_INSTRUCTION+") REFERENCES "+
                RecipeContract.RecipeInstruction.TABLE_NAME+"("+RecipeContract.RecipeInstruction._ID+"));";

        sqLiteDatabase.execSQL(SQL_CREATE_RECIPE_LINKED_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + RecipeContract.TitleAndTypeOfRecipe.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + RecipeContract.RecipeIngredient.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + RecipeContract.RecipeInstruction.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + RecipeContract.RecipeLinked.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
