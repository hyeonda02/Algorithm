import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    //최단경로, 그냥 시작 정점부터 주어진 정점까지 가는 최단 거리 출력, 없다면 INF 출력
    static int V,E,K;   //V:정점의 개수, E:간선의 개수, K:시작 정점
    static int u,v,w;   //u에서 v로 가는 가중치 w인 간선이 존재한다.
    static ArrayList<Edge> list[];
    static boolean visited[];
    static int distance[];
    static PriorityQueue<Edge>pQueue = new PriorityQueue<Edge>();
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        visited = new boolean[V+1];
        distance = new int[V+1];
        list = new ArrayList[V+1];
        for(int i=1;i<=V;i++)
            list[i]= new ArrayList<Edge>();
        //거리배열 초기화
        for(int i=0;i<=V;i++)
            distance[i] = Integer.MAX_VALUE;
        //가중치 존재하는 인접 리스트 초기화
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v,w));
        }
        //시작 노드 설정
        pQueue.add(new Edge(K,0));
        distance[K]=0;
        while(!pQueue.isEmpty()){
            Edge currentEdge = pQueue.poll();
            int current_v = currentEdge.vertex;
            if(visited[current_v]) continue;
            visited[current_v] = true;
            for(int i=0;i<list[current_v].size();i++){
                Edge temp = list[current_v].get(i);
                int next = temp.vertex;
                int value = temp.value;
                if(distance[next]>distance[current_v]+value) {
                    distance[next] = value + distance[current_v];
                    pQueue.add(new Edge(next, distance[next]));
                }
            }
        }
        for(int i=1;i<=V;i++){
            if(visited[i]) System.out.println(distance[i]);
            else System.out.println("INF");
        }

    }

}
class Edge implements Comparable<Edge>{
    int vertex,value;
     Edge(int vertex,int value){
        this.value=value;
        this.vertex=vertex;
    }
    public int compareTo(Edge e) {
        if(this.value>e.value) return 1;
        else return -1;
    }
}
