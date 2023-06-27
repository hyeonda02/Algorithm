import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //p1325,효율적인 해킹
    static int N;
    static int M;
    static boolean visited[];
    static int answer[];
    static ArrayList<Integer> arr[];
    public static void main(String[]args)throws IOException {
        //방향 그래프 이므로, 인접 리스트 이용해서 구현
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];
        answer = new int[N+1];

        for(int i=1;i<N+1;i++){
            arr[i] = new ArrayList<>();
        }
        //입력값 ArrayList에 저장
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            arr[S].add(E);
        }
        //BFS를 모든 노드에 대해 실행
        for(int i=1;i<N+1;i++){
            visited = new boolean[N+1];
            BFS(i);
        }
        int max=0;
        for(int i=1;i<N+1;i++){
            if(answer[i]>max)
                max=Math.max(max,answer[i]);
        }
        //가장 큰 값과 배열의 값이 같다면 정답
        for(int i=1;i<N+1;i++){
            if(max==answer[i])
                System.out.print(i+" ");
        }
    }
    //BFS
    private static void BFS(int Node){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(Node);
        visited[Node] = true;
        while(!queue.isEmpty()){
            int now_node = queue.poll();
            for(int i:arr[now_node]){
                if(visited[i]==false){
                    visited[i]=true;
                    answer[i]++;
                    queue.add(i);
                }
            }
        }
    }
}
