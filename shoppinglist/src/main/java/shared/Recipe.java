package shared;

import java.util.ArrayList;
import java.util.Objects;

import javafx.scene.image.Image;

import lmerge.*;

public class Recipe {
    public String name;
    public Image image;
    public ArrayList<ListElement> ingredients;


    public Recipe() {
    }

    public Recipe(String name, Image image, ArrayList<ListElement> ingredients) {
        this.name = name;
        this.image = image;
        this.ingredients = ingredients;
    }
    

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Recipe)) {
            return false;
        }
        Recipe recipe = (Recipe) o;
        return Objects.equals(name, recipe.name) && Objects.equals(image, recipe.image) && Objects.equals(ingredients, recipe.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, image, ingredients);
    }
}
