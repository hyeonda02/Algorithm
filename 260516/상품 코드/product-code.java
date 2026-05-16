import java.util.Scanner;

class Product {
    String name;
    int code;
    public Product() {
        this.name = "codetree";
        this.code = 50;
    }

    public void setter(String name, int code) {
        this.name = name;
        this.code = code;
    }
}

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Product product1 = new Product();
        Product product2 = new Product();
        System.out.println("product "+product1.code+" is "+product1.name);

        Scanner scanner =  new Scanner(System.in);
        String name = scanner.next();
        int code = scanner.nextInt();

        product2.setter(name,code);
        System.out.println("product "+product2.code+" is "+product2.name);


    }
}