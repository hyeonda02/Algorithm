import java.util.*;

public class Main {
    static int a;
    static int b;
    static int[] arr;

    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        arr = new int[10];
        arr[0] = scanner.nextInt();
        arr[1] = scanner.nextInt();

        System.out.print(arr[0]+" "+arr[1]+" ");

        for(int i=2;i<10;i++){
            arr[i] = (arr[i-2]+arr[i-1])%10;
            System.out.print(arr[i] +" ");
        }
    }
}