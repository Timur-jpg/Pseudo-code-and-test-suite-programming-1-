import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

/**
 * The test class RecipeTest.
 * @author Jad Dayoub
 * @version December 21, 2025
 */
public class RecipeBookTest {
    private RecipeBook book;
    private Recipe recipe1;
    private Recipe recipe2;

    @BeforeEach
    public void setUp() {
        book = new RecipeBook("My Recipe Book");
        recipe1 = new Recipe("Pancakes");
        recipe2 = new Recipe("Spaghetti");

        book.addRecipe(recipe1);
        book.addRecipe(recipe2);
    }

    @Test
    public void testGetTitle() {
        assertEquals("My Recipe Book", book.getTitle());
    }

    @Test
    public void testAddRecipe() {
        Recipe recipe3 = new Recipe("Salad");
        book.addRecipe(recipe3);
        assertEquals(2, book.getRecipes().size());
    }

    @Test
    public void testRemoveRecipe() {
        boolean removed = book.removeRecipe("Pancakes");
        assertTrue(removed);
        assertEquals(1, book.getRecipes().size());
    }

    @Test
    public void testRemoveRecipeNotFound() {
        boolean removed = book.removeRecipe("Pizza");
        assertFalse(removed);
    }

    @Test
    public void testSearchByTitle() {
        List<Recipe> results = book.searchByTitle("Spa");
        assertEquals(1, results.size());
        assertEquals("Spaghetti", results.get(0).getTitle());
    }
}