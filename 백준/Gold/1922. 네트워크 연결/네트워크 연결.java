import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] parent;
    static PriorityQueue<pedge> pQueue;
    static class pedge implements Comparable<pedge>{
        int start;
        int end;
        int cost;
        public pedge(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(pedge o) {
            return this.cost-o.cost;
        }
    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b) parent[b]=a;
    }
    public static int find(int a){
        if(parent[a]==a)
            return a;
        else return parent[a] = find(parent[a]);
    }
    public static void MST(){
        int result=0;
        int useEdge=1;
        while(useEdge<N){
            pedge nowedge = pQueue.poll();
            if(find(nowedge.start)!=find(nowedge.end)){
                union(nowedge.start, nowedge.end);
                result= result + nowedge.cost;
                useEdge++;


            }
        }
        System.out.println(result);


    }
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        for(int i=0;i<N+1;i++)
            parent[i] = i;
        pQueue = new PriorityQueue<>();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pQueue.add(new pedge(start, end, cost));
        }
        MST();


    }
}
