import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private List<Product> database;

    public ProductRepository() {
        this.database = new ArrayList<>() {
            {
                add(new Product(1, "computer", 1000.0));
                add(new Product(2, "mouse", 50.0));
                add(new Product(3, "teclado", 100.0));
            }
        };
    }

    public Product findById(int id) {
        return database.stream().filter(p -> p.id() == id).findFirst().orElse(null);
    }
}
