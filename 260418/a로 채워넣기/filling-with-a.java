import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String result = a.substring(0,1)+"a"+a.substring(2,a.length()-2)+"a"+a.substring(a.length()-1,a.length());
        System.out.println(result);

    }
}