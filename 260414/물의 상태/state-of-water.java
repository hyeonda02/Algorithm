import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        if(num<0) {
            System.out.println("ice");
        }else if(num>=100){
            System.out.println("vapor");
        }else {
            System.out.println("water");
        }
        
    }
}