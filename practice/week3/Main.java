package practice.week3;

public class Main {
    public static void main(String[] args) {
        Shop shopee = new Shop();
        shopee.name = "Kaizer Cigarettes";

        Product product1 = new Product("Malboro Red", 155.00, 50, 1);
        Product product2 = new Product("Dunhill", 200.00, 30, 2);
        Product product3 = new Product("Marlboro Gold", 180.00, 40, 3);

        Product[] products = new Product[3];
        shopee.productList = products;

        products[0] = product1;
        products[1] = product2;
        products[2] = product3;

        shopee.displayProducts();
    }

    
}   
