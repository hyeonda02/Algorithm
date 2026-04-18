import java.util.*;


public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        String result = "";
        if(str1.length()>str2.length()){
            result = str1 + " " + str1.length();
        }else if(str1.length()<str2.length()){
            result = str2 + " " + str2.length();
        }else {
            result = "same";
        }
        System.out.println(result);
    }
}