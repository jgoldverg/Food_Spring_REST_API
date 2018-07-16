package food.controller;

import food.domain.Ingredient;
import food.service.IngredientService;
import food.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public class RecipeController
{

    @Autowired
    private IngredientService service;
    private RecipeService recipeService;

    @RequestMapping(path = "/ingredients", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ingredient>> show()
    {
        service.loadFood();
        return ResponseEntity
                .ok().body(service.getIngredientList().getIngredientArrayList());
    }

    @RequestMapping(path = "/recipes", produces = MediaType.APPLICATION_JSON_VALUE)
    public String sendList(){
        return "hello";
    }



}
