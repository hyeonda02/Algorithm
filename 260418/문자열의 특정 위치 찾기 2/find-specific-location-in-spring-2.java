import java.util.*;

public class Main {
    static String[] arr = {"apple", "banana", "grape", "blueberry", "orange"};
    static int cnt;
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        char c = scanner.next().charAt(0);
        cnt = 0;

        for(int i=0;i<arr.length;i++){
            if((arr[i].charAt(2))==c||(arr[i].charAt(3))==c) {
                System.out.println(arr[i]);
                cnt++;
            
            }
        }
        System.out.println(cnt);
    }
}