import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    //p1931 회의실 배정
    //1<=N<=100000 , 시작 시간, 끝나는 시간
    //회의의 끝나는 시간이 빠를 수록, 다음 회의 시작 시간과 겹치지 않을 수 있다.
    //따라서 끝나는 시간이 빠른 것 을 기준으로 정렬
    //그리디
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[][] arr = new int[N][2];
        for(int i=0;i<N;i++){
            arr[i][0] = scanner.nextInt();
            arr[i][1] =scanner.nextInt();
        }
        //끝나는 시간이 빠른 순으로 정렬 Compare() 이용
        Arrays.sort(arr, new Comparator<int[] >() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1]-o2[1];
            }
        });
        int count=0;
        int end=-1;
        
        for(int i=0;i<N;i++){
            if(arr[i][0]>=end){
                end = arr[i][1];
                count++;
            }
        }
        System.out.println(count);

    }
}
