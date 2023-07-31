import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    //벡준p11657 - 타임머신
    static class nodes5{
        int start;
        int end;
        int cost;
        public nodes5(int start, int end, int cost){
            this.cost = cost;
            this.start = start;
            this.end = end;
        }
    }
    static int N,M;
    static int A,B,C;
    static long[] dist;
    static ArrayList<nodes5>graph;
    static final int INF = Integer.MAX_VALUE;
    public static boolean bellmanford(){
        dist[1]=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                nodes5 nownode = graph.get(j);
                if(dist[nownode.start]!=INF&&dist[nownode.end]>dist[nownode.start]+nownode.cost)
                    dist[nownode.end] = dist[nownode.start]+ nownode.cost;
            }
        }

        for(int i=0;i<M;i++){
            nodes5 nownode = graph.get(i);
            if(dist[nownode.start]!=INF&&dist[nownode.end]>dist[nownode.start]+ nownode.cost) {
                System.out.println("-1");
                return false;
            }

        }
        for(int i=2;i<=N;i++){
            if(dist[i]==INF) System.out.println("-1");
            else System.out.println(dist[i]);
        }
        return true;
    }
    public static void main(String[]args)throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   //도시 개수
        M = Integer.parseInt(st.nextToken());   //버스 노선 개수

        dist = new long[N+1];
        Arrays.fill(dist,INF);
        graph= new ArrayList<>();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            graph.add(new nodes5(A,B,C));

        }
        bellmanford();
    }
}
