import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    //p11725 트리의 부모 찾기
    static int N;
    static ArrayList<Integer> tree[];
    static boolean[] visited;
    static int[] answer;
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        visited = new boolean[N+1];
        answer = new int[N+1];
        for(int i=0;i<tree.length;i++){
            tree[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for(int i=1;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            tree[node2].add(node1);
            tree[node1].add(node2);

        }
        DFS(1); //부모 노드부터 DFS 실행
        for(int i=2;i<=N;i++){
            System.out.println(answer[i]);
        }
    }
    static void DFS(int node){
        visited[node] = true;
        for(int i: tree[node]){
            if(!visited[i]){
                answer[i] = node;
                DFS(i);
            }

        }
    }
}
