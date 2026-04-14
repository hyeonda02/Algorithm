import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        System.out.println((N>=80)? "pass" : (80-N)+" more score");

    }
}