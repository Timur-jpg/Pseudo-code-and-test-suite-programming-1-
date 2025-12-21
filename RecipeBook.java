import java.util.ArrayList;
import java.util.List;
/**
 * Represents collection of recipes.
 * Allows user to add, remove, list and search recipes.
 * @author Jad Dayoub & Timur Turdaliev
 * @version December 21, 2025
 */
public class RecipeBook
{
    private String title;
    private List<Recipe> recipes;
    /**
     * Creates new recipe book.
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
    
    /**
     * Adds a recipe to the recipe book.
     */
    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }
    
    /**
     * Removes a recipe by title.
     */
    public boolean removeRecipe(String title) {
        for (int i = 0; i < recipes.size(); i++) {
            if (recipes.get(i).getTitle().equals(title)) {
                recipes.remove(i);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Prints the titles of all the recipes in the book.
     */
    public void listAllRecipes() {
        for (Recipe recipe : recipes) {
            System.out.println(recipe.getTitle());
        }
    }
    
    public void printBookDetails() {
        System.out.println("Recipe Book: " + title);
        System.out.println("Total recipes: " + recipes.size());
    }
    
    /**
     * Searches for recipes of given title.
     */
    public List<Recipe> searchByTitle(String title) {
        List<Recipe> results = new ArrayList<>();
        for (Recipe recipe : recipes) {
            if (recipe.getTitle().contains(title)) {
            results.add(recipe);
            }
        }
        return results;
    }
    
    /**
     * Searches for recipes of specified class.
     */
    public List<Recipe> searchByType(Class type) {
        List<Recipe> results = new ArrayList<>();
        for (Recipe recipe : recipes) {
            if (recipe.getClass() == type) {
            results.add(recipe);
            }
        }
        return results;
    }
    
    /** 
     * Searches for recipes containing a specific ingredient.
    */
    public List<Recipe> searchByIngredient(String ingredientName) {
        List<Recipe> results = new ArrayList<>();
        for (Recipe recipe : recipes) {
            if (recipe.containsIngredient(ingredientName)) {
                results.add(recipe);
            }
        }
        return results;
    }
    
    /**
     * Searches for recipes with a specific tag.
     */
    public List<Recipe> searchByTag(Tag tag) {
        List<Recipe> results = new ArrayList<>();
        for (Recipe recipe : recipes) {
            if (recipe.hasTag(tag)) {
                results.add(recipe);
            }
        }
        return results;
    }
}