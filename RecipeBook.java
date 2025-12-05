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
    
    public boolean removeRecipe(String title){
        for (Recipe recipe : recipes) {
            if (recipe.getTitle().equals(title)) {
                recipes.remove(recipe);
                return true;
            }
        }
        return false;
    }
    
    public void listAllRecipes() {
        for (Recipe recipes : recipes) {
            System.out.println(recipes.getTitle());
        }
    }
    
        public void printBookDetails() {
        System.out.println("Recipe Book: " + title);
        System.out.println("Total recipes: " + recipes.size());
    }
    
    //to add: searchByTitle, searchByType, searchByIngredient, searchByType
}