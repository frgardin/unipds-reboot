public class App {
    public static void main(String[] args) throws Exception {
        ProductRepository pr = new ProductRepository();

        Product p = pr.findById(3);
        System.out.println(p);

        Product p2 = pr.findById(4);
        System.out.println(p2.name());
    }
}
