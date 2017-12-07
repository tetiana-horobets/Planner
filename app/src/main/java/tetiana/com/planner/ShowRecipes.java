package tetiana.com.planner;

class ShowRecipes {
    private String title, recipeType;

    ShowRecipes(String title, String recipeType) {
        this.title = title;
        this.recipeType = recipeType;
    }

    String getTitle() {
        return title;
    }

    String getRecipeType() {
        return recipeType;
    }
}
