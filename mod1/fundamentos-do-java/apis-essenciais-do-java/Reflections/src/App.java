public class App {
    public static void main(String[] args) throws Exception {
        Product p = new Product(1, "computador", 1000.0);
        ClassExplorer.exploreMetadata(p);
    }
}
