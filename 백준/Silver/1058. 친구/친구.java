import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //1058 친구
    static int N;
    static int graph[][];
    static final int INF = 987654321;
    public static void floyd(){
        for(int k=1;k<N+1;k++){
            for(int i =1;i<N+1;i++){
                for(int j=1;j<N+1;j++){
                    if(graph[i][j]>graph[i][k]+graph[k][j])
                        graph[i][j] = graph[i][k]+graph[k][j];
                }
            }
        }
        int max = 0;
        for(int i=1;i<N+1;i++){
            int temp = 0;
            for(int j=1;j<N+1;j++){
                if(i==j) continue;
                if(graph[i][j]==1 || graph[i][j]==2) temp++;
            }
            if(max<temp) max = temp;
        }
        System.out.println(max);

    }
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph =  new int[N+1][N+1];
        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                if(i==j) graph[i][j] = 0;
                else graph[i][j] = INF;
            }
        }
        for(int i=1;i<N+1;i++){
            String str = br.readLine();
            for(int j=1;j<N+1;j++){
                if(i==j) continue;
                else {
                    char a = str.charAt(j-1);
                    if (a == 'Y') graph[i][j] = 1;
                }
            }
        }
        floyd();
    }
}
