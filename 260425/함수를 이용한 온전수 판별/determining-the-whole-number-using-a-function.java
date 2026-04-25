import java.util.Scanner;

public class Main {
    public static boolean checkNum(int a){
        if(a%2==0||a%10==5) return false;
        if(a%3==0&&a%9!=0) return false;
        return true;

    }
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int result = 0;

        for(int i=A;i<=B;i++){
            if(checkNum(i)){
                result++;
            }
        }

        System.out.println(result);

    }
}