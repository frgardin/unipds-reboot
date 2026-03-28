
static class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Product p)) {
            return false;
        }

        return Objects.equals(this.id, p.id) && 
                Objects.equals(this.name, p.name) &&
                 Objects.equals(this.price, p.price);
    }

    @Override
    public int hashCode() {
        return id;
    }
}

long benchmarkMap(int size) {
    long start, end;
    Map<Product, Product>m = new HashMap<>(size);
    
    for (int i = 1;i<=size;i++) {
        var p = new Product(i, "name " + i, i*10.0);
        m.put(p, p);
    }

    start = System.currentTimeMillis(); 

    for(int i =1;i<=size;i++) {
        var p = new Product(i, "name " + i, i*10.0);
        if (m.containsKey(p)) {
            continue;
        }
    }
    
    end = System.currentTimeMillis();
    return end-start;
}

long benchmarkList(int size) {
    long start, end;
    List<Product> l = new ArrayList<>(size);
    
    for (int i =1; i<=size;i++) {
        var p = new Product(i, "name " + i, i*10.0);
        l.add(p);
    } 

    start = System.currentTimeMillis();

    for (int i = 1; i<=size;i++) {
        var p = new Product(i, "name " + i, i*10.0);
        if (l.contains(p)) {
            continue;
        }
    }

    end = System.currentTimeMillis();
    
    return end-start;
}

    
void main() {        
    Scanner sc= new Scanner(System.in);
    int n = sc.nextInt();
    
    IO.println("Time Spent List: " + benchmarkList(n) + " ms");
    IO.println("Time Spent Map: " + benchmarkMap(n) + " ms");
}



