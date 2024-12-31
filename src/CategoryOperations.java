import java.util.HashSet;
import java.util.Set;

public class CategoryOperations {
    private Set<Category> categories = new HashSet<>();

    public void addCategory(String name) {
        categories.add(new Category(name));
    }

    public void listCategories() {
        categories.forEach(category -> System.out.println(category.getName()));
    }

    public boolean categoryExists(String name) {
        return categories.stream().anyMatch(category -> category.getName().equalsIgnoreCase(name));
    }
}