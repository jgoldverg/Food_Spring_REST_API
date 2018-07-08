package food_test;

import food.service.IngredientService;
import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientServiceTest
{
    IngredientService testObj;

    @Test
    public void preLoadFood()
    {
        testObj = new IngredientService();
        assertNull(testObj.getIngredientList());
    }

    @Test
    public void postLoadFood()
    {
        testObj = new IngredientService();
        testObj.loadFood();
        assertNotNull(testObj.getIngredientList());
    }

}