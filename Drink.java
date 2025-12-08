public class Drink extends Recipe {

    private boolean alcoholic;

    public Drink(String title) {
        super(title);
    }

    public boolean isAlcoholic() {
        return alcoholic;
    }

    public void setAlcoholic(boolean alcoholic) {
        this.alcoholic = alcoholic;
    }
}