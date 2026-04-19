import java.util.*;

public class Main {
    static int N;
    static int M;
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print("* ");
            }
            System.out.println("");
        }
    }
}