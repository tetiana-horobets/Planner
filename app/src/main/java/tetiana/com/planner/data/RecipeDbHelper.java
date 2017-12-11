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

        final String SQL_CREATE_RECIPE_TABLE = "CREATE TABLE " + RecipeContract.RecipeEntry.TABLE_NAME + " (" +
                RecipeContract.RecipeEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                RecipeContract.RecipeEntry.COLUMN_RECIPE_TITLE + " TEXT NOT NULL, " +
                RecipeContract.RecipeEntry.COLUMN_RECIPE_TYPE + " TEXT NOT NULL " +
                "); ";

        sqLiteDatabase.execSQL(SQL_CREATE_RECIPE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + RecipeContract.RecipeEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
