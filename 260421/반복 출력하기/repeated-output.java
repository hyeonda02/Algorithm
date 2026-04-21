import java.util.*;

public class Main {
    public static void printStr(int cnt){
        for(int i=0;i<cnt;i++){
            System.out.println("12345^&*()_");
        }
    }

    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        printStr(cnt);
        
    }
}