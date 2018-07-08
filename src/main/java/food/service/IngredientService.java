package food.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import food.domain.Ingredient;
import food.domain.IngredientsList;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class IngredientService
{
    private IngredientsList ingredients;
    private boolean called;

    public void loadFood()
    {
        ingredients = new IngredientsList();
        StringBuilder sb = new StringBuilder();
        try {

            URL url = new URL("https://www.themealdb.com/api/json/v1/1/list.php?i=list");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;

            while ((output = br.readLine()) != null) {
                sb.append(output);
            }
            readLine(sb.toString());
            conn.disconnect();
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {

            e.printStackTrace();
        }
    }

    private void readLine(String data)
    {
        JsonParser jsonParser = new JsonParser();
        JsonObject objectFromString = jsonParser.parse(data).getAsJsonObject();
        JsonArray arr = objectFromString.getAsJsonArray("meals");
        for(int i = 0; i < arr.size(); i++)
        {
            JsonObject temp = arr.get(i).getAsJsonObject();
            String id = temp.get("idIngredient").toString();
            String name = temp.get("strIngredient").toString();
            String description = temp.get("strDescription").toString();
            String type = temp.get("strType").toString();
            Ingredient ingredient = new Ingredient(id, name,description, type);
            ingredients.add(ingredient);
        }
    }


    public IngredientsList getIngredientList()
    {
        return ingredients;
    }

    public boolean isCalled()
    {
        return called;
    }

    public void called(boolean called)
    {
        this.called = called;
    }
}