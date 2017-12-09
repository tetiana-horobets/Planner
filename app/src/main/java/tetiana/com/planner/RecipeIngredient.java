package tetiana.com.planner;

class RecipeIngredient {
    private String ingredient;
    private String quantity;
    private String unit;

    RecipeIngredient(String ingredient, String quantity, String unit) {
        this.ingredient = ingredient;
        this.quantity = quantity;
        this.unit = unit;
    }

    String getIngredient() {
        return ingredient;
    }

    public String getUnit() {
        return unit;
    }

    public String getQuantity() {
        return quantity;
    }
}
