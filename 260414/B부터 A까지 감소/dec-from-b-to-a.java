import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        for(int i=B;i>=A;i--){
            System.out.print(i+" ");
        }

    }
}