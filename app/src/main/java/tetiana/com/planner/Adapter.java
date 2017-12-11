package tetiana.com.planner;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tetiana.com.planner.data.RecipeContract;


class Adapter extends RecyclerView.Adapter<Adapter.RecipeViewHolder> {

    private Cursor mCursor;
    private Context mContext;

    Adapter(Context context, Cursor cursor) {
        this.mContext = context;
        this.mCursor = cursor;
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.recipe_list_item, viewGroup, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int position) {
        if (!mCursor.moveToPosition(position))
            return;
        String title = mCursor.getString(mCursor.getColumnIndex(RecipeContract.RecipeEntry.COLUMN_RECIPE_TITLE));
        String type = mCursor.getString(mCursor.getColumnIndex(RecipeContract.RecipeEntry.COLUMN_RECIPE_TYPE));
        holder.titleTv.setText(title);
        holder.recipeType.setText((type));
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder {
        TextView titleTv, recipeType;

        private RecipeViewHolder(View view) {
            super(view);
            titleTv = view.findViewById(R.id.titley);
            recipeType = view.findViewById(R.id.recipe);
        }

    }
}
