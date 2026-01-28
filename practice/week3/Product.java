package practice.week3;

public class Product {
    private String name;
    private double price;
    private int stock;
    static int productCount;

    public Product(){}

    public Product(String name, double price, int stock, int productCount) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        Product.productCount = productCount;
    }

    public String getInfo(){
        return name  + " - " + price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

}