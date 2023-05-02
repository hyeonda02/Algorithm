import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        long start =1, end = K;
        long answer=0;

        //이진 탐색 시작하기
        while(start<=end){
            long middle = (start+end)/2;
            long cnt = 0;
            //중앙 값 보다 작은 수의 개수 세기
            for(int i=1;i<=N;i++){
                cnt +=Math.min(middle/i,N);
            }
            if(cnt<K){
                start=middle +1;
            }else{
                answer = middle;
                end = middle-1;
            }

        }
        System.out.println(answer);
    }

}
