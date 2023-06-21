import java.util.Scanner;

public class Main {
    //p1456 거의 소수
    //입력값의 최재값이 10^14 이므로, 제곱근은 10^7
    //따라서 에라토스테네스의 체를 사용 ->2~10^7 까지 소수를 탐색
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        long Min = scanner.nextLong();
        long Max = scanner.nextLong();
        long[] arr = new long[10000001];
        for(int i=2;i<arr.length;i++){
            arr[i] = i;
        }
        for(int i=2;i<=Math.sqrt(arr.length);i++){
            if(arr[i]==0) continue;
            for(int j=i+i;j<arr.length;j+=i){
                arr[j]=0;
            }
        }
        int count=0;
        for(int i=2;i<10000001;i++){
            if(arr[i]!=0){
                long temp = arr[i];
                while((double)arr[i]<=(double)Max/(double)temp){
                    if((double)arr[i]>=(double)Min/(double)temp){
                        count++;
                    }
                    temp = temp*arr[i];
                }
            }
        }
        System.out.println(count);
    }
}
