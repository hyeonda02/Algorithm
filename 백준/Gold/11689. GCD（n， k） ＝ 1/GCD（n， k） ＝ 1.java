import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //오일러 피 함수
    //p11689 - GCD(n,k) =1
    public static void main(String[]args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(bf.readLine());
        long result =n;
        for(long i =2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                result = result - result/i;
                while(n%i==0){
                    n/=i;
                }
            }
        }
        //반복문을 제곱근까지만 탐색했기 때문에 1개의 소인수가 누락되는 케이스 처리
        if(n>1) result = result - result/n;     //아직 소인수 구성이 남아 있을때
        System.out.println(result);
    }
}
