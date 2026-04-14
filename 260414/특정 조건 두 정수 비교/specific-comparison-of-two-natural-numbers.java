import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        System.out.print((A<B)?1:0);
        System.out.print(" ");
        System.out.println((A==B)?1:0);
    }
}