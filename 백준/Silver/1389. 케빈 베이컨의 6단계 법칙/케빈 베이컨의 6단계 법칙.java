import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //p1389 케빈 베이컨의 6단계 법칙
    static int N;
    static int M;
    static int graph[][];
    static int distance[];
    static final int INF = 10000001;
    public static void floyd(){
        for(int k=1;k<N+1;k++){
            for (int i=1;i<N+1;i++){
                for(int j=1;j<N+1;j++){
                    if(graph[i][j]>graph[i][k]+graph[k][j])
                        graph[i][j] = graph[i][k]+graph[k][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int answer = -1;
        for(int i=1;i<N+1;i++){
            int temp =0;
            for(int j=1;j<N+1;j++){
                temp =temp+graph[i][j];
            }
            if(min>temp){
                min = temp;
                answer = i;
            }
        }
        System.out.println(answer);


    }
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N+1][N+1];
        for(int i=0;i<N+1;i++){
            for(int j=0;j<N+1;j++){
                if(i==j) graph[i][j] = 0;
                else graph[i][j] = INF;
            }
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start][end]=1;
            graph[end][start]=1;
        }
        floyd();

    }
}
