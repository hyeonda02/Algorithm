import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    static int N;
    static int K;
    static int[] dataArray;
    //동전의 최소 개수 구하기
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dataArray = new int[N];

        for(int i=0;i<N;i++){
            dataArray[i] = Integer.parseInt(br.readLine());
        }
        int count=0;
        for(int i = N-1;i>=0;i--){
            if(dataArray[i]<=K){
                count+=(K/dataArray[i]);
                K=K%dataArray[i];
            }
        }
        System.out.println(count);
    }
}
