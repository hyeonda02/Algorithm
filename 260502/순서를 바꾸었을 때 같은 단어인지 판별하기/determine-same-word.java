import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.next();
        String word2 = sc.next();
        // Please write your code here.
        char[] charA = word1.toCharArray();
        char[] charB = word2.toCharArray();

        Arrays.sort(charA);
        Arrays.sort(charB);
        if(Arrays.equals(charA,charB)) System.out.println("Yes");
        else System.out.println("No");
    }
}