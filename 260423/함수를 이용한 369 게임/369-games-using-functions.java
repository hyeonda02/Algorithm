import java.util.*;

public class Main {
    public static boolean isContain(int n){
        String strN = String.valueOf(n);
        if(strN.contains("3")||strN.contains("6")||strN.contains("9")) return true;
        return false;

    }
    public static boolean isMagicNum(int n){
        if(n%3==0||isContain(n)) return true;
        return false;

    }
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int cnt = 0;

        for(int i=A;i<=B;i++){
            if(isMagicNum(i)) cnt++;
        }
        System.out.println(cnt);
    
    }
}