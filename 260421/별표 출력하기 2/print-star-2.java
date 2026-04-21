import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        for(int i=N;i>0;i--){
           for(int j=0;j<i;j++){
            System.out.print("* ");
           }
           System.out.println();
        }

    }
}