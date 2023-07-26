import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    //최소 비용 구하기
    static int N;
    static int M;
    static Boolean[] visited;
    static int[] dist;
    static ArrayList<Node3>[] graph;
    static final int INF = Integer.MAX_VALUE;

    public static void dijkstra(int start, int end){
        Arrays.fill(dist,INF);
        Arrays.fill(visited,false);
        dist[start]=0;
        PriorityQueue<Node3> pq = new PriorityQueue<>();
        pq.offer(new Node3(start,0));
        while(!pq.isEmpty()){
            int nowNode = pq.poll().index;
            if(visited[nowNode]) continue;
            visited[nowNode]=true;
            for(Node3 next :graph[nowNode]){
                if(dist[next.index]>dist[nowNode]+next.cost){
                    dist[next.index]=dist[nowNode]+next.cost;
                    pq.offer(new Node3(next.index,dist[next.index]));
                }
            }
        }
        System.out.println(dist[end]);

    }
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visited = new Boolean[N+1];
        graph = new ArrayList[N+1];
        dist = new int[N+1];

        for(int i=0;i<=N;i++) graph[i] = new ArrayList<>();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[s].add(new Node3(e,w));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start,end);
    }
}
class Node3 implements Comparable<Node3>{
    int index;
    int cost;
    public Node3(int index, int cost){
        this.index=index;
        this.cost=cost;
    }

    @Override
    public int compareTo(Node3 o) {
        return this.cost-o.cost;
    }
}