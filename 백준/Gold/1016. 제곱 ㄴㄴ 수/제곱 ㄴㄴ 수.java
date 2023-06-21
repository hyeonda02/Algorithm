import java.util.Scanner;

public class Main {
    //p1016 제곱 ㄴㄴ수
    //정수론, 에라토스테네스의 체
    //1<min<=1000000000000
    //min<=max<=min+1000000
    public static void main(String[]args){

        Scanner scanner = new Scanner(System.in);
        long min = scanner.nextLong();
        long max = scanner.nextLong();
        //최댓값과 최솟값의 차이만큼 배열 선언하기
        boolean[] Check = new boolean[(int)(max-min+1)];
        //2의 제곱수인 4부터 Max보다 작거나 같은 값까지 반복하기
        for(long i=2;i*i<=max;i++){
            long pow = i*i;//제곱수
            long start_index = min/pow;
            if(min%pow!=0) start_index++;
            for(long j = start_index;pow*j<=max;j++){
                Check[(int)((j*pow)-min)] = true;
            }
        }
        int count=0;
        for(int i=0;i<=max-min;i++){
            if(!Check[i]) count++;
        }
    System.out.println(count);

    }
}
