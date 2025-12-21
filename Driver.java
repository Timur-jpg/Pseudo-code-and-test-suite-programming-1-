import java.util.List;
import java.util.Scanner;

/**
 * Driver class for the Recipe Book application.
 * 
 * @author Jad Dayoub
 * @version December 18, 2025
 */
public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecipeBook book = new RecipeBook("My Recipe Book");
        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("=======================================");
            System.out.println("              RECIPE BOOK              ");
            System.out.println("=======================================");
            System.out.println("1) Print recipe book details");
            System.out.println("2) List all recipes");
            System.out.println("3) Add a recipe");
            System.out.println("4) Remove a recipe");
            System.out.println("5) Search recipes by title");
            System.out.println("6) Search recipes by ingredient");
            System.out.println("7) Search recipes by tag");
            System.out.println("8) Print recipe details");
            System.out.println("9) Rate a recipe");
            System.out.println("10) Scale recipe servings");
            System.out.println("---------------------------------------");
            System.out.println("0) Exit");
            System.out.println("=======================================");
            System.out.print("Choose: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    book.printBookDetails();
                    break;

                case "2":
                    if (book.getRecipes().isEmpty()) {
                        System.out.println("No recipes in the book.");
                    } else {
                        book.listAllRecipes();
                    }
                    break;

                case "3":
                    addRecipe(book, scanner);
                    break;

                case "4":
                    System.out.print("Enter recipe title to remove: ");
                    String removeTitle = scanner.nextLine();

                    if (book.removeRecipe(removeTitle)) {
                        System.out.println("Recipe removed successfully.");
                    } else {
                        System.out.println("Recipe not found.");
                    }
                    break;

                case "5":
                    System.out.print("Enter title to search: ");
                    printSearchResults(book.searchByTitle(scanner.nextLine()));
                    break;

                case "6":
                    System.out.print("Enter ingredient to search: ");
                    printSearchResults(book.searchByIngredient(scanner.nextLine()));
                    break;

                case "7":
                    System.out.print("Enter tag (e.g. EASY, QUICK): ");
                    try {
                        Tag tag = Tag.valueOf(scanner.nextLine().toUpperCase());
                        printSearchResults(book.searchByTag(tag));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid tag.");
                    }
                    break;

                case "8":
                    printRecipeDetails(book, scanner);
                    break;

                case "9":
                    rateRecipe(book, scanner);
                    break;

                case "10":
                    scaleRecipe(book, scanner);
                    break;

                case "0":
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    /**
     * Prompts user to create a new recipe and add it to recipe book.
     */
    private static void addRecipe(RecipeBook book, Scanner scanner) {

        System.out.print("Enter recipe title: ");
        String title = scanner.nextLine();

        if (title.isEmpty()) {
            System.out.println("Title cannot be empty.");
            return;
        }

        // Select recipe type (subclass)
        System.out.println("Select recipe type:");
        System.out.println("1) Main Course");
        System.out.println("2) Dessert");
        System.out.println("3) Drink");
        System.out.print("Choose: ");

        String typeChoice = scanner.nextLine();
        Recipe recipe;

        if (typeChoice.equals("1")) {
            recipe = new MainCourse(title);
            System.out.print("Is it spicy? (true/false): ");
            ((MainCourse) recipe).setSpicy(Boolean.parseBoolean(scanner.nextLine()));
        } else if (typeChoice.equals("2")) {
            recipe = new Dessert(title);
            System.out.print("Sweetness level (1-10): ");
            try {
                ((Dessert) recipe).setSweetnessLevel(
                    Integer.parseInt(scanner.nextLine())
                );
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Defaulting to 5.");
                ((Dessert) recipe).setSweetnessLevel(5);
            }

        } else if (typeChoice.equals("3")) {
            recipe = new Drink(title);
            System.out.print("Is it alcoholic? (true/false): ");
            ((Drink) recipe).setAlcoholic(Boolean.parseBoolean(scanner.nextLine()));

        } else {
            System.out.println("Invalid choice. Defaulting to Main Course.");
            recipe = new MainCourse(title);
        }

        // Ingredients
        while (true) {
            System.out.print("Add ingredient title (or press Enter to stop): ");
            String ingTitle = scanner.nextLine();
            if (ingTitle.isEmpty()) break;

            System.out.print("Amount: ");
            double amount;
            try {
                amount = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount.");
                continue;
            }

            System.out.print("Unit (CUP, GRAM, ML): ");
            try {
                Unit unit = Unit.valueOf(scanner.nextLine().toUpperCase());
                recipe.addIngredient(new Ingredients(ingTitle, amount, unit));
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid unit.");
            }
        }

        // Steps
        while (true) {
            System.out.print("Add step (or press Enter to stop): ");
            String step = scanner.nextLine();
            if (step.isEmpty()) break;
            recipe.addStep(step);
        }

        book.addRecipe(recipe);
        System.out.println("Recipe added.");
        
        // Tags
        while (true) {
        System.out.print("Add tag? (y/n): ");
        String yn = scanner.nextLine().toLowerCase();
        if (!yn.equals("y")) break;
        System.out.print("Enter tag: ");
        try {
            Tag tag = Tag.valueOf(scanner.nextLine().toUpperCase());
            recipe.tags.add(tag); // or recipe.addTag(tag) if you have that method
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid tag.");
        }
        }
    }

    /**
     * Prints information for selected recipe.
     */
    private static void printRecipeDetails(RecipeBook book, Scanner scanner) {
        System.out.print("Enter recipe title: ");
        String title = scanner.nextLine();
        for (Recipe r : book.getRecipes()) {
            if (r.getTitle().equals(title)) {
                r.printDetails();
                System.out.println("Servings: " + r.getServings());
                System.out.println("Average rating: " + r.getAverageRating());
                return;
            }
        }
        System.out.println("Recipe not found.");
    }

    /**
     * Allows user to rate recipe.
     */
    private static void rateRecipe(RecipeBook book, Scanner scanner) {
        System.out.print("Enter recipe title to rate: ");
        String title = scanner.nextLine();
        for (Recipe r : book.getRecipes()) {
            if (r.getTitle().equals(title)) {
                System.out.print("Enter rating (1-5): ");
                try {
                    int rating = Integer.parseInt(scanner.nextLine());
                    r.addRating(rating);
                    System.out.println("Rating added.");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid rating.");
                }
                return;
            }
        }
        System.out.println("Recipe not found.");
    }

    /**
     * Scales recipe to given number of servings.
     */
    private static void scaleRecipe(RecipeBook book, Scanner scanner) {
        System.out.print("Enter recipe title to scale: ");
        String title = scanner.nextLine();
        for (Recipe r : book.getRecipes()) {
            if (r.getTitle().equals(title)) {
                System.out.print("Enter new number of servings: ");
                try {
                    int servings = Integer.parseInt(scanner.nextLine());
                    r.scaleServings(servings);
                    System.out.println("Recipe scaled to " + servings + " servings.");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number.");
                }
                return;
            }
        }
        System.out.println("Recipe not found.");
    }

    /**
     * Prints list of recipes returned from a search.
     */
    private static void printSearchResults(List<Recipe> results) {
        if (results.isEmpty()) {
            System.out.println("No matching recipes found.");
        } else {
            for (Recipe r : results) {
                System.out.println("- " + r.getTitle());
            }
        }
    }
}