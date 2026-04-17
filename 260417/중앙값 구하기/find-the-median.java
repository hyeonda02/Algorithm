import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();

        if((A>B&&A<C)||(A>C&&A<B)){
            System.out.println(A);
        }else if((A<B&&B<C)||(C<B&&B<A)){
            System.out.println(B);
        }else{
            System.out.println(C);
        }
    }
}