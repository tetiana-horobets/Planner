package tetiana.com.planner;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tetiana.com.planner.data.RecipeContract;

import static android.support.v7.recyclerview.R.styleable.RecyclerView;

class Adapter extends RecyclerView.Adapter<Adapter.RecipeViewHolder> {

    final private ListItemClickListener mOnClickListener;


    private Cursor mCursor;
    private Context mContext;

    Adapter(Context context, Cursor cursor, ListItemClickListener listener) {
        this.mContext = context;
        this.mCursor = cursor;
        this.mOnClickListener = listener;
    }

    interface ListItemClickListener {
        void onListItemClick(int clickedPosition);
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.recipe_list_item, viewGroup, false);
        return new RecipeViewHolder(view);
    }

    public void swapCursor(Cursor newCursor) {
        if (mCursor != null) mCursor.close();
        if (newCursor != null) {
            this.notifyDataSetChanged();
        }
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int position) {
        if (!mCursor.moveToPosition(position))
            return;
        String title = mCursor.getString(mCursor.getColumnIndex(RecipeContract.TitleAndTypeOfRecipe.COLUMN_RECIPE_TITLE));
        String type = mCursor.getString(mCursor.getColumnIndex(RecipeContract.TitleAndTypeOfRecipe.COLUMN_RECIPE_TYPE));
        holder.titleTv.setText(title);
        holder.recipeType.setText((type));
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titleTv, recipeType;

        private RecipeViewHolder(View view) {
            super(view);
            titleTv = view.findViewById(R.id.titley);
            recipeType = view.findViewById(R.id.recipe);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);
        }
    }
}
