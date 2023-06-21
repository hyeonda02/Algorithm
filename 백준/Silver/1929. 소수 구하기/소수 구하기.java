import java.util.Scanner;

public class Main {
    //p1929 소수 구하기
    //정수론, 에라토스테네스의 체
    //N의 최대범위가 1000000이므로, 에라토스테네스 방법 사용
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int[] arr = new int[N+1];
        for(int i=2;i<=N;i++){
            arr[i] = i;
        }
        //제곱근까지만 수행
        for(int i=2;i<=Math.sqrt(N);i++){
            if(arr[i] ==0){
                continue;
            }
            for(int j=i+i;j<=N;j+=i){
                arr[j]=0;
            }
        }
        for(int i=M;i<N+1;i++){
            if(arr[i]!=0)
                System.out.println(arr[i]);
        }
    }
}
