package tetiana.com.planner;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class Adapter extends RecyclerView.Adapter<Adapter.NumberViewHolder> {

    final private ListItemClickListener mOnClickListener;

    private List<ShowRecipes> moviesList;

    Adapter(List<ShowRecipes> moviesList, ListItemClickListener listener) {
        this.moviesList = moviesList;
        mOnClickListener = listener;

    }

    interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.recipe_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, viewGroup, false);

        return new NumberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {
        ShowRecipes recipes = moviesList.get(position);
        holder.title.setText(recipes.getTitle());
        holder.recipeType.setText(recipes.getRecipeType());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    class NumberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title, recipeType;

        private NumberViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.titley);
            recipeType = view.findViewById(R.id.recipe);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);
        }
    }
}
