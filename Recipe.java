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
    private List<Integer> ratings;
    private int servings;
    
    /**
     * Constructor for objects of class Recipe
     */
    public Recipe(String title)
    {
        this.title = title;
        this.ingredients = new ArrayList<>();
        this.steps = new ArrayList<>();
        this.tags = new ArrayList<>();
        this.ratings = new ArrayList<>();
        this.servings = 1;
    }
    
    public String getTitle() {
        return title;
    }

    public boolean containsIngredient(String ingredientName) {
        for (Ingredients ing : ingredients) {
            if (ing.getTitle().equals(ingredientName)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasTag(Tag tag) {
        return tags.contains(tag);
    }
    
    public void addIngredient(Ingredients ingredient) {
        ingredients.add(ingredient);
    }

    public boolean removeIngredient(String name) {
        for (int i = 0; i < ingredients.size(); i++) {
            if (ingredients.get(i).getTitle().equals(name)) {
                ingredients.remove(i);
                return true;
            }
        }
        return false;
    }

    public void addStep(String step) {
        steps.add(step);
    }

    public boolean removeStep(int i) {
        if (i >= 0 && i < steps.size()) {
            steps.remove(i);
            return true;
        }
        return false;
    }
    
    /**
     * Returns the number of servings.
     */
    public int getServings() {
        return servings;
    }

    /**
     * Scales ingredient amounts to a new number of servings.
     */
    public void scaleServings(int newServings) {
        if (newServings <= 0) return;
        double factor = (double) newServings / servings;
        for (Ingredients ing : ingredients) {
            double newAmount = ing.getAmount() * factor;
            ing.setAmount(newAmount);
        }
        servings = newServings;
    }
    
        /**
     * Adds a rating for this recipe.
     * Rating must be between 1 and 5.
     */
    public void addRating(int rating) {
        if (rating >= 1 && rating <= 5) {
        ratings.add(rating);
        }
    }

    /**
     * Returns the average rating of the recipe.
     */
    public double getAverageRating() {
        if (ratings.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (int r : ratings) {
            sum += r;
        }
        return (double) sum / ratings.size();
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
            System.out.println(t);
        }
        
    }
}
