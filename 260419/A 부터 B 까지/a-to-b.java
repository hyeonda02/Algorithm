import java.util.*;

public class Main {
    static int A;
    static int B;
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        A = scanner.nextInt();
        B = scanner.nextInt();

        while(A<=B){
            System.out.print(A+" ");
            if(A%2==0){
                A += 3;
            }else {
                A *= 2;
            }

        }

    }
}