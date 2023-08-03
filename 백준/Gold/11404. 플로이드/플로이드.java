import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //백준 p11404 플로이드
    static int n;
    static int m;
    static final int INF = 10000001;
    static int[][] graph;
    public static void floyd(){
        for(int k=1;k<n+1;k++){
            for(int i=1;i<n+1;i++){
                for(int j=1;j<n+1;j++){
                    if(graph[i][j]>graph[i][k]+graph[k][j])
                        graph[i][j] = graph[i][k]+graph[k][j];
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(graph[i][j] == INF ) System.out.print("0 ");
                else System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }

    }
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new int[n+1][n+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==j) graph[i][j]=0;
                else graph[i][j] = INF;
            }
        }
        StringTokenizer st;
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if(graph[start][end]>cost) graph[start][end] = cost;
        }
        floyd();
    }
}
