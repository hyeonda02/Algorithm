import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();

        if(A>B){
            if(A<C){System.out.println(A);}
            else{System.out.println(C);}
        }else{
            if(B<C) {System.out.println(B);}
            else{System.out.println(C);}
        }


    }
}