package practice.week3;

public class Shop {
    String name;
    Product[] productList;

    public Shop(){}

    public Shop(String name, Product[] list){
        this.name = name;
        this.productList = list;
    }

    public void displayProducts(){
        for (Product p : productList) {
            System.out.println("Product Name: " + p.getName());
            System.out.println("Price: " + p.getPrice());
            System.out.println("Stock: " + p.getStock());
            System.out.println("-----------------------");
        }
    }

}
