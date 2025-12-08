import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Recipe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Recipe
{
    public String title;
    public List<Ingredients> ingredients;
    public List<String> steps;
    public List<Tag> tags;

    /**
     * Constructor for objects of class Recipe
     */
    public Recipe(String title)
    {
        this.title = title;
        this.ingredients = new ArrayList<>();
        this.steps = new ArrayList<>();
        this.tags = new ArrayList<>();

    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void printDetails()
    {
        System.out.println("=== " + title + " ===");

        System.out.println("\nIngredients:");
        for (Ingredients ing : ingredients) {
            System.out.println(" - " + ing.toString());

        }
        
        System.out.println("\nSteps:");
        int i = 1;
        for (String step : steps) {
            System.out.println(i + ". " + step);
            i++;
        }
        
        System.out.println("\nTags:");
        for (Tag t : tags) {
            System.out.println(" #" + t);
        }
        
    }
}
