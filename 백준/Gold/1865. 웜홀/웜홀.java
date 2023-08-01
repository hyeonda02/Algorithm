import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    //p1865 웜홀
    static class node5{
        int start;
        int end;
        int cost;
        public node5(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
    static int TC;  //테스트 케이스 수
    static int N;   //지점의 수
    static int M;   //도로의 개수(무방향 그래프)
    static int W;   //웜홀의 개수 (방향 그래프)
    static int[] dist;
    static boolean minuCheck=false;
    static boolean ck;
    static ArrayList<node5> graph;
    static final int INF = Integer.MAX_VALUE;
    public static boolean bellmanford(int start){
        Arrays.fill(dist,INF);
        dist[start] = 0;
        for(int i=1;i<=N;i++){
            ck=false;
            for(int j=0;j< graph.size(); j++){
                node5 nownode = graph.get(j);
                if(dist[nownode.start]!=INF&&dist[nownode.end]>dist[nownode.start]+ nownode.cost){
                    dist[nownode.end] = dist[nownode.start]+ nownode.cost;
                    ck = true;
                    if(i==N) return true;
                }

            }
            if(!ck) break;
        }
        return false;
    }
    public static void main(String[]args)throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());

        for(int j=0;j<TC;j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            dist = new int[N + 1];
            Arrays.fill(dist,INF);
            graph = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                graph.add(new node5(S, E, T));
                graph.add(new node5(E,S,T));
            }
            for(int i=0;i<W;i++){
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                graph.add(new node5(S,E,-T));
            }
            for(int i=1;i<=N;i++){
                if(bellmanford(i)){
                    sb.append("YES\n");
                    break;
                }
            }
            if(!ck) sb.append("NO\n");
        }
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
    }
}
