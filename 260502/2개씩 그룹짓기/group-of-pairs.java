import java.util.*;

public class Main {
    public static int n;
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] arr = new int[n*2];
        for(int i=0;i<n*2;i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int answer = 0;
        for(int i=0;i<n;i++){
            int sum = arr[i]+arr[arr.length-i-1];
            if(sum>=answer) answer = sum;
        }
        System.out.println(answer);
    }
}