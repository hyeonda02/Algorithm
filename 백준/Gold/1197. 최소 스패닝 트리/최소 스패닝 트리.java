import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int V;
    static int E;
    static int[] parent;
    static PriorityQueue<pEdge> queue;

    static class pEdge implements Comparable<pEdge>{
        int start, end, cost;
        pEdge(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(pEdge o) {
            return this.cost-o.cost;
        }
    }
    public static void union(int a, int b){
        a = find(a);
        b=find(b);
        if(a!=b){
            parent[b] =a;
        }
    }
    public static int find(int a){
        if ( parent[a]==a)
            return a;
        else return parent[a] = find(parent[a]);
    }
    public static void MST(){
        int result=0;
        int useEdge=1;
        while(useEdge<V){
            pEdge nowNode = queue.poll();
            if(find(nowNode.start)!=find(nowNode.end)){
                union(nowNode.start,nowNode.end);
                result = result + nowNode.cost;
                useEdge++;
            }
        }
        System.out.println(result);
    }
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parent = new int[V+1];
        for(int i=0;i<V+1;i++){
            parent[i] = i;
        }
        queue = new PriorityQueue<>();
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            queue.add(new pEdge(start,end,cost));
        }
        MST();
    }
}
