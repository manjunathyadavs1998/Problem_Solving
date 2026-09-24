package DesignPatterns.Builder;

public class ProductMain {
    public static void main(String[] args) {
        Product pd= new Product.Builder().addId(1L).addName("Samsung S20").addTitle("Samsung S20, 420R").build();
        System.out.println(pd.getName());
    }
}
