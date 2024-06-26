import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//특정한 최단 경로

/**
 * < 조건 정리 >
 * 한번 이동했던 정점은 물론, 한번 이동했던 간선도 다시 이동 가능
 * 1번 정점에서 N번 정점으로 최단 거리로 이동
 * 그러나, 두 정점은 무조건 통과해야됨
 * N,E ( 정점, 간선 )
 * essential1, essential2 필수로 방문해야되는 정점
 */
public class Main {
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int[] distance;
    static final int INF = 100000000;
    static int N;
    static int E;
    static int essential1;
    static int essential2;
    static class Node implements Comparable<Node>{
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    static int dijkstraPQ(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(distance, INF);
        Arrays.fill(visited, false);
        pq.offer(new Node(start, 0));
        distance[start] =0;
        while (!pq.isEmpty()) {
            int nowVertex = pq.poll().index;
            if(visited[nowVertex]) continue;
            visited[nowVertex] = true;
            for (Node next : graph[nowVertex]) {
                if (distance[next.index] > distance[nowVertex] + next.cost) {
                    distance[next.index] = distance[nowVertex]+next.cost;
                    pq.offer(new Node(next.index, distance[next.index]));
                }
            }
        }
        return distance[end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        distance = new int[N+1];
        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }


        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[s].add(new Node(e, w));
            graph[e].add(new Node(s, w));
        }
        st = new StringTokenizer(br.readLine());
        essential1 = Integer.parseInt(st.nextToken());
        essential2 = Integer.parseInt(st.nextToken());

        int answer1 = 0;
        answer1 += dijkstraPQ(1, essential1);
        answer1 += dijkstraPQ(essential1, essential2);
        answer1 += dijkstraPQ(essential2, N);
        int answer2=0;
        answer2+=dijkstraPQ(1,essential2);
        answer2+=dijkstraPQ(essential2,essential1);
        answer2+=dijkstraPQ(essential1,N);
        int ans = (answer1>=INF && answer2>=INF)?-1:Math.min(answer1,answer2);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(ans+"\n");
        bw.flush();
        bw.close();
        br.close();




    }
}