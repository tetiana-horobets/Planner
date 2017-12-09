package tetiana.com.planner;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class Adapter extends RecyclerView.Adapter<Adapter.RecipeViewHolder> {

    final private ListItemClickListener mOnClickListener;

    private List<DataRecipe> recipesList;

    Adapter(List<DataRecipe> dataRecipes, ListItemClickListener listener) {
        this.recipesList = dataRecipes;
        mOnClickListener = listener;
    }

    interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.recipe_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, viewGroup, false);

        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int position) {
        DataRecipe recipes = recipesList.get(position);
        holder.title.setText(recipes.getTitle());
        holder.recipeType.setText(recipes.getRecipeType());
    }

    @Override
    public int getItemCount() {
        if (this.recipesList==null) {
            return 0;
        }
        return this.recipesList.size();
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title, recipeType;

        private RecipeViewHolder(View view) {
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
