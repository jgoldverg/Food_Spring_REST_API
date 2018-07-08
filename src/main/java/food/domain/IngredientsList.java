package food.domain;

import java.util.ArrayList;
import java.util.List;

public class IngredientsList
{
     private List<Ingredient> ingredientArrayList;

    public IngredientsList(){
        ingredientArrayList = new ArrayList<>();
    }

    public IngredientsList(ArrayList<Ingredient> ingredientArrayList) {
        this.ingredientArrayList = ingredientArrayList;
    }
    public List<Ingredient> getIngredientArrayList() {
        return ingredientArrayList;
    }

    public void setIngredientArrayList(List<Ingredient> ingredientArrayList) {
        this.ingredientArrayList = ingredientArrayList;
    }

    public void add(Ingredient ingredient){
        ingredientArrayList.add(ingredient);
    }

    public Ingredient get(int index){
        return ingredientArrayList.get(index);
    }

    public Ingredient remove(int index){
        Ingredient ingredient = ingredientArrayList.remove(index);
        return ingredient;
    }
}
