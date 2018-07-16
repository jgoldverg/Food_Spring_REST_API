package food.domain;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class RecipeList
{
    private ArrayList<Recipe> recipes;
    private int size;
    String type; //saved Recipes,

    public RecipeList(String type)
    {
        recipes = new ArrayList<>();
        size = 0;
        this.type = type;
    }

    public String toJson()
    {
        String json = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().
                create().toJson(getRecipes());
        return json;
    }

    public ArrayList<Recipe> getRecipes()
    {
        return recipes;
    }
}
