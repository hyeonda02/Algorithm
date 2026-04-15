import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        int a_m = scanner.nextInt();
        int a_e = scanner.nextInt();
        int b_m = scanner.nextInt();
        int b_e = scanner.nextInt();

        if(a_m>b_m&&a_e>b_e){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}