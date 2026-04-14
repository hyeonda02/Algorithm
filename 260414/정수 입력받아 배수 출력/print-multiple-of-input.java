import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int result = N;

        for(int i=0;i<5;i++){
            System.out.print(result+" ");
            result += N;
        }
    }
}