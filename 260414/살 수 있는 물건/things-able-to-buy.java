import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.

        Scanner scanner = new Scanner(System.in);
        int price = scanner.nextInt();
        if(price>=3000){
            System.out.println("book");
        }else if (price>=1000){
            System.out.println("mask");
        }else {
            System.out.println("no");
        }
    }
}