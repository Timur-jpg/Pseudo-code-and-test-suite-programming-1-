public class MainCourse extends Recipe {

    private boolean spicy;

    public MainCourse(String title) {
        super(title);
    }

    public boolean isSpicy() {
        return spicy;
    }

    public void setSpicy(boolean spicy) {
        this.spicy = spicy;
    }
}
