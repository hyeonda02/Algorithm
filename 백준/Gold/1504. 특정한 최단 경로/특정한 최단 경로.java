import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class Main {
    static int N;
    static int E;
    static int essential1;
    static int essential2;

    static final int INF = 100000000;

    static ArrayList<ArrayList<Node1>> graph;
    static boolean[] visited;

    static int distance[];
    static class Node1 implements Comparable<Node1>{
        int index;
        int cost;
        public Node1(int index, int cost){
            this.index=index;
            this.cost=cost;
        }

        @Override
        public int compareTo(Node1 o) {
            return cost-o.cost;

        }
    }
    public static int dijkstra(int start, int end){
        PriorityQueue<Node1> pq= new PriorityQueue<>();
        Arrays.fill(distance,INF);
        Arrays.fill(visited,false);
        pq.offer(new Node1(start,0));
        distance[start]=0;
        while(!pq.isEmpty()){
            int nowVertex = pq.poll().index;
            if(visited[nowVertex]) continue;
            visited[nowVertex]=true;

            for(Node1 next: graph.get(nowVertex)){
                if(distance[next.index]>distance[nowVertex]+ next.cost) {
                    distance[next.index] = distance[nowVertex] + next.cost;
                    pq.offer(new Node1(next.index,distance[next.index]));
                }
            }

        }
        return distance[end];

    }
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());


        graph = new ArrayList<>();
        distance = new int[N+1];
        visited=new boolean[N+1];

        Arrays.fill(distance, INF);

        for(int i=0;i<N+1;i++) graph.add(new ArrayList<>());

        for(int i=0;i<E;i++){
            st=new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            // start에서 end로 가는 weight (가중치)
            graph.get(s).add(new Node1(e, w));

            // end에서 start로 가는 weight (가중치)
            graph.get(e).add(new Node1(s, w));
        }
        st = new StringTokenizer(br.readLine());
        essential1 = Integer.parseInt(st.nextToken());
        essential2 = Integer.parseInt(st.nextToken());

        int answer1 =0;
        answer1+=dijkstra(1,essential1);
        answer1+=dijkstra(essential1,essential2);
        answer1+=dijkstra(essential2,N);


        int answer2=0;
        answer2+=dijkstra(1,essential2);
        answer2+=dijkstra(essential2,essential1);
        answer2+=dijkstra(essential1,N);


        int ans = (answer1>=INF && answer2>=INF)?-1:Math.min(answer1,answer2);
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(ans+"\n");
        bw.flush();
        bw.close();
        br.close();


    }
}