package tetiana.com.planner;


import java.util.ArrayList;
import java.util.List;

class DataRecipe {
    private String title, recipeType;
    private RecipeIngredient ingredient;
    private RecipeInstruction instruction;

    private DataRecipe(String title, String recipeType, RecipeIngredient ingredient, RecipeInstruction instruction) {
        this.title = title;
        this.recipeType = recipeType;
        this.ingredient = ingredient;
        this.instruction = instruction;
    }

    String getTitle() {
        return title;
    }

    String getRecipeType() {
        return recipeType;
    }

    RecipeIngredient getIngredient() {
        return ingredient;
    }

    static List<DataRecipe> prepareRecipeData(){
        List<DataRecipe> dataRecipeList = new ArrayList<>();

        DataRecipe dataRecipe = new DataRecipe("Sunny-Side Up Fried Eggs","breakfast", new RecipeIngredient("Eggs", "1", "unit"), new RecipeInstruction("\n" +
                "Heat butter in a cast iron, carbon steel, or nonstick skillet over medium heat until" +
                " lightly foaming, tilting pan to evenly distribute the melted butter. Carefully break eggs into the skillet," +
                " season with salt, and cook until the whites are just set on top and the yolks are still runny, about 3 minutes." +
                " Transfer to a plate, season with pepper if desired, and serve immediately."));
        dataRecipeList.add(dataRecipe);

        dataRecipe = new DataRecipe("Berry and Yogurt Smoothie","breakfast", new RecipeIngredient("yogurt", "1", "unit"), new RecipeInstruction("A blend of bananas, blueberries and blackberries are added to the smoothie. Greek yogurt and soy milk are added to give the smoothie tons of protein and a creamy, thick consistency.\n" +
                "\n" +
                "This smoothie has no added sugar. The banana and berries add a natural sweetness to the smoothie.\n" +
                "\n" +
                "You can substitute frozen berries in this smoothie but I prefer fresh myself."));
        dataRecipeList.add(dataRecipe);

        dataRecipe = new DataRecipe("Chicken","diner", new RecipeIngredient("solt", "0,5", "kg"), new RecipeInstruction("chicken recipe"));
        dataRecipeList.add(dataRecipe);

        dataRecipe = new DataRecipe("Sous","diner", new RecipeIngredient("milk", "0,5", "l"), new RecipeInstruction("sous recipe"));
        dataRecipeList.add(dataRecipe);
        return dataRecipeList;
    }

    @Override
    public String toString() {
        return "DataRecipe{" +
                "title='" + title + '\'' +
                ", recipeType='" + recipeType + '\'' +
                ", ingredient=" + ingredient +
                ", instruction=" + instruction +
                '}';
    }
}