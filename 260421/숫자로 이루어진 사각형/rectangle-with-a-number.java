import java.util.*;

public class Main {
    public static void printSquare(int N) {
        int num = 1;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(num%10==0){
                    num = 1;
                    System.out.print(num+" ");
                }else{
                    System.out.print(num%10+" ");
                }
                num++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        printSquare(N);

    }
}