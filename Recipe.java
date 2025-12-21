import java.util.ArrayList;
import java.util.List;

/**
 * Reprensents a cooking recipe, containing title, ingredients, preparation steps, tags,
 * servings information, and user ratings.
 * @author Jad Dayoub & Timur Turdaliev
 * @version December 21, 2025
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
     * Creates new recipe with given title.
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
    
    /**
     * Checks if the recipe contains given ingredient.
     */
    public boolean containsIngredient(String ingredientName) {
        for (Ingredients ing : ingredients) {
            if (ing.getTitle().equals(ingredientName)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks if recipe has said tags.
     */
    public boolean hasTag(Tag tag) {
        return tags.contains(tag);
    }
    
    public void addIngredient(Ingredients ingredient) {
        ingredients.add(ingredient);
    }
    /**
     * Removes an ingredient by name.
     */
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
    
    /**
     * Removes step by given step.
     */
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
     * Scales ingredient amounts to new number of servings.
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
     * Adds a rating between 1 and 5 for recipe.
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
     * Prints recipe details.
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
