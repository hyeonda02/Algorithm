import java.lang.reflect.Array;
import java.util.*;

public class Main {
    //18352 특정 거리의 도시 찾기
    //X로부터 출발해 도달할 수 있는 모든 도시 중 최단 거리가 정확히 K인 모든 도시들의 번호를 출력
    static int M,N,K,X;
    static ArrayList<Integer>[] arr;
    static List<Integer> answer;
    static int visited[];


    public static void main(String[]args){

        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        K = scanner.nextInt();
        X = scanner.nextInt();
        arr = new ArrayList[N+1];
        answer = new ArrayList<>();
        for(int i=1;i<=N;i++){
            arr[i] = new ArrayList<Integer>();
        }
        for(int i=0;i<M;i++){
            int S = scanner.nextInt();
            int E = scanner.nextInt();
            arr[S].add(E);
        }
        visited = new int[N+1];
        for(int i=0;i<N+1;i++){
            visited[i] = -1;
        }
        BFS(X);
        for(int i=0;i<=N;i++){
            if(visited[i] == K)
                answer.add(i);
        }
        if(answer.isEmpty()) System.out.println("-1");
        else {
            Collections.sort(answer);
            for(int i:answer)
                System.out.println(i);

        }


    }
    private static void BFS(int Node){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(Node);
        visited[Node]++;
        while(!queue.isEmpty()){
            int now_Node = queue.poll();
            for(int i: arr[now_Node]){
                if(visited[i]==-1){
                    visited[i] = visited[now_Node]+1;
                    queue.add(i);
                }
            }
        }
    }

}
