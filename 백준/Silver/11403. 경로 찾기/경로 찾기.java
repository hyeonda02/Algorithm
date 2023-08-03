import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //p11403 경로찾기
    static int N;
    static int[][] G;
    public static void floyd(){
        for(int k=0;k<N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(G[i][k]==1&&G[k][j]==1) G[i][j]=1;
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(G[i][j]+" ");
            }
            System.out.println();
        }

    }
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        G = new int[N+1][N+1];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                G[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        floyd();
    }
}
