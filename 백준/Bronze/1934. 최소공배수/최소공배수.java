import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        //p1934 - 최소 공배수
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i=0;i<T;i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int result = a*b/gcd(a,b);
            System.out.println(result);
        }
    }
    //최대 공약수를 구하는 연산 (유클리드 호제법 이용) -> 일반적으로 gcd 로 정의한다.
    private static int gcd(int a, int b){
        if(b==0)
            return a;
        else return gcd(b,a%b);
    }
}
