/**
 * Represents a dessert recipe.
 * Dessert's sweetness is rated out of 10.
 */
public class Dessert extends Recipe {
    
    private int sweetnessLevel;
    
    public Dessert(String title) {
        super(title);
    }

    public int getSweetnessLevel() {
        return sweetnessLevel;
    }

    public void setSweetnessLevel(int sweetnessLevel) {
        this.sweetnessLevel = sweetnessLevel;
    }
}