import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n;
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] arrA = new int[n];
        int[] arrB = new int[n];

        for(int i=0;i<n;i++){
            arrA[i] = scanner.nextInt();
        }
        for(int i=0;i<n;i++){
            arrB[i] = scanner.nextInt();
        }
        Arrays.sort(arrA);
        Arrays.sort(arrB);

        if(Arrays.equals(arrA,arrB)) System.out.println("Yes");
        else System.out.println("No");


    }
}