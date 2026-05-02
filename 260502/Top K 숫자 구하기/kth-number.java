import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n;
    public static int k;
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();

        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);
        System.out.println(arr[k-1]);

    }
}