import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;    //노드 개수
    static int M;    //엣지 개수
    static int V;   //시작점
    static boolean visited[]; //방문 체크 배열
    static ArrayList<Integer>[] A; //그래프 데이터 저장 인접 리스트

    public static void main(String[]args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            A[i] = new ArrayList<Integer>();
        }
        //A인접 리스트에 그래프 데이터 저장하기
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            A[S].add(E);
            A[E].add(S);
        }
        //방문할 수 있는 노드가 여러 개일 경우에는 번호가 작은 것을 번저 방문하기 위해 정렬하기
        //즉, 번호가 작은 것을 먼저 방문하기 위해 정렬하기
        for(int i=1;i<=N;i++){
            Collections.sort(A[i]);
        }
        //방문 배열 초기화 하기
        visited = new boolean[N + 1];
        DFS(V);
        System.out.println();
        //다시 방문 배열 초기화 한 후 BFS 실행
        visited = new boolean[N + 1];
        BFS(V);
        System.out.println();

    }
    //DFS 구현
    public static void DFS(int start){
        System.out.print(start+" ");
        visited[start]=true;
        for(int i: A[start]){
            if(!visited[i])
                DFS(i);
        }
    }
    //BFS 구현
    public static void BFS(int start){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int nowNode = queue.poll();
            System.out.print(nowNode+" ");
            for(int i:A[nowNode]){
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

}
