import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        char[] arr = str.toCharArray();

        Arrays.sort(arr);
        String newStr = new String(arr);
    
        System.out.println(newStr);
    }
}