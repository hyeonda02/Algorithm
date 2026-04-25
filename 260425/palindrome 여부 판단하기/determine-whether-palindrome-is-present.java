import java.util.Scanner;

public class Main {
    public static String solution(String before){
        String after = "";
        for(int i=before.length()-1;i>=0;i--){
            after += before.charAt(i);
        }
        return after;
    }
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        String before = scanner.next();

        String after = solution(before);

        System.out.println((before.equals(after))?"Yes":"No");

    }
}