package food.controller;

import food.domain.Ingredient;
import food.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IngredientsListController
{

    @Autowired
    private IngredientService service;

    @RequestMapping(path = "/ingredients", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ingredient>> show()
    {
        service.loadFood();
        return ResponseEntity
                .ok().body(service.getIngredientList().getIngredientArrayList());
    }
}

