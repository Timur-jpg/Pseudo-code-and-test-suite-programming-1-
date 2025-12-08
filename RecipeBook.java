import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class RecipeBook here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RecipeBook
{
    private String title;
    private List<Recipe> recipes;

    /**
     * Constructor
     */
    public RecipeBook(String title)
    {
        this.title = title;
        this.recipes = new ArrayList<>();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    
    public List<Recipe> getRecipes(){
        return recipes;
    }
    
    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }
    
    public boolean removeRecipe(String title) {
        for (int i = 0; i < recipes.size(); i++) {
            if (recipes.get(i).getTitle().equals(title)) {
                recipes.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public void listAllRecipes() {
        for (Recipe recipe : recipes) {
            System.out.println(recipe.getTitle());
        }
    }
    
    public void printBookDetails() {
        System.out.println("Recipe Book: " + title);
        System.out.println("Total recipes: " + recipes.size());
    }
    
    public List<Recipe> searchByTitle(String title) {
        List<Recipe> results = new ArrayList<>();
        for (Recipe recipe : recipes) {
            if (recipe.getTitle().contains(title)) {
            results.add(recipe);
            }
        }
        return results;
    }
    
    public List<Recipe> searchByType(Class type) {
        List<Recipe> results = new ArrayList<>();
        for (Recipe recipe : recipes) {
            if (recipe.getClass() == type) {
            results.add(recipe);
            }
        }
        return results;
    }
    
    public List<Recipe> searchByIngredient(String ingredientName) {
        List<Recipe> results = new ArrayList<>();
        for (Recipe recipe : recipes) {
            if (recipe.containsIngredient(ingredientName)) {
                results.add(recipe);
            }
        }
        return results;
    }
    
    public List<Recipe> searchByTag(Tag tag) {
        List<Recipe> results = new ArrayList<>();
        for (Recipe recipe : recipes) {
            if (recipe.hasTag(tag)) {
                results.add(recipe);
            }
        }
        return results;
    }
    //Methods to be declared in Recipe class
}