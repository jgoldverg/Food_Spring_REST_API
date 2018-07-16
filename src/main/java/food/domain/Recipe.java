package food.domain;

import java.util.LinkedList;

public class Recipe
{
    LinkedList<Ingredient> ingredientsForRecipe;
    String nameOfrecipe;
    String id;

    public Recipe(LinkedList<Ingredient> ingredientsForRecipe, String nameOfrecipe, String id)
    {
        this.ingredientsForRecipe = ingredientsForRecipe;
        this.nameOfrecipe = nameOfrecipe;
        this.id = id;
    }

    public LinkedList<Ingredient> getIngredientsForRecipe()
    {
        return ingredientsForRecipe;
    }

    public void setIngredientsForRecipe(LinkedList<Ingredient> ingredientsForRecipe)
    {
        this.ingredientsForRecipe = ingredientsForRecipe;
    }

    public String getNameOfrecipe()
    {
        return nameOfrecipe;
    }

    public void setNameOfrecipe(String nameOfrecipe)
    {
        this.nameOfrecipe = nameOfrecipe;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }
}
