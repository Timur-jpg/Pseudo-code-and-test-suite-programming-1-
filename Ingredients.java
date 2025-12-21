
/**
 * Represents an ingredient in a recipe.
 * Store name, amount, and unit.
 * @author Timur Turdaliev & Jad Dayoub
 * @version December 21, 2025
 */
public class Ingredients
{
    private String title;
    private double amount;
    private Unit unit;
    
    /**
     * Creates new ingredient.
     */
    public Ingredients(String title, double amount, Unit unit)
    {
        this.title = title;
        this.amount = amount;
        this.unit = unit;
    }
    
    public String getTitle() {
        return title;
    }

    public double getAmount() {
        return amount;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public Unit getUnit() {
        return unit;
    }
    
    /**
     * Returns readable representation of ingredient.
     */
    @Override
    public String toString() {
        return amount + " " + unit + " " + title;
    }
}
