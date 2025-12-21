
/**
 * Write a description of class Ingredients here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ingredients
{
    private String title;
    private double amount;
    private Unit unit;
    
    /**
     * Constructor for objects of class Ingredients
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

    public Unit getUnit() {
        return unit;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    @Override
    public String toString() {
        return amount + " " + unit + " " + title;
    }
}
