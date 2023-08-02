import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    //백준p1219 - 오민식의 고민
    static int N;
    static int M;
    static int i; //출발
    static int j; //도착
    static ArrayList<nodes1> graph;
    static long dist[];
    static long money[];

    static class nodes1{
        int start;
        int end;
        int cost;
        public nodes1(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
    public static void bellmanford(){
        dist[i] = money[i];
        for(int i=0;i<=N+100;i++){
            for(int j=0;j<M;j++){
                nodes1 nowNode = graph.get(j);
                int start = nowNode.start;
                int end = nowNode.end;
                int price = nowNode.cost;
                //출발 노드가 방문하지 않은 노드라면 skip
                if(dist[start] == Long.MIN_VALUE) continue;
                //출발 노드가 양수 사이클에 연결된 노드라면 종료 노드도 연결노드로 업데이트
                else if(dist[start] == Long.MAX_VALUE) dist[end] = Long.MAX_VALUE;
                //더 많은 돈을 벌 수 있는 새로운 경로가 있다면 그것으로 업데이트
                else if ( dist[end]<dist[start]+money[end]-price) {
                    dist[end] = dist[start] + money[end] - price;
                    //N-1 반복 이후 업데이트되는 종료 노드는 양수 사이클 연결 노드로 변경
                    if (i >= N - 1) dist[end] = Long.MAX_VALUE;
                }
            }
        }
        //도착 불가능
        if(dist[j]==Long.MIN_VALUE) System.out.println("gg");   //도착 불가능
        else if(dist[j]==Long.MAX_VALUE) System.out.println("Gee"); //양수 사이클에 연결되어 돈을 많이 벌수 있을 대
        else System.out.println(dist[j]);
    }
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        i = Integer.parseInt(st.nextToken());
        j = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new long[N+1];
        money = new long[N+1];
        Arrays.fill(dist,Long.MIN_VALUE);
        graph = new ArrayList<>();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.add(new nodes1(start,end,cost));
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            money[i] = Long.parseLong(st.nextToken());
        }
        bellmanford();
    }
}
