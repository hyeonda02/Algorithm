import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int result = a+b;
        
        String answer = "" + a + " + " + b + " = "+ result;

        System.out.println(answer);
    }
}