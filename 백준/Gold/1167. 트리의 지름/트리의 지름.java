import java.util.*;

public class Main {
    static boolean[] visited;    //노드 방문했는지 확인하는 array
    static int[] distance;        // 거리 배열
    static ArrayList<Edge>[] array;   //노드(노드 번호, 노드 거리) 클래스를 담을 ArrayList
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();   //노드 개수 입력
        array = new ArrayList[N+1];
        for(int i=1;i<=N;i++){   //ArrayList 초기화
            array[i] = new ArrayList<Edge>();
        }
        for(int i=0;i<N;i++){   //array 인접 리스트에 그래프 데이터 저장하기
            int S = scanner.nextInt();
            while(true){
                int E = scanner.nextInt();
                if(E==-1) break;
                int V = scanner.nextInt();
                array[S].add(new Edge(E,V));

            }
        }
        visited = new boolean[N+1]; //visited 배열 초기화 하기
        distance = new int[N+1];    //distance 배열 초기화 하기
        BFS(1); //BFS 탐색 시작 ( 임의의 시작점 )
        //distance 배열 중에서 가장 큰 값을 선정해서 거기서부터 다시 BFS 시작하기
        int MAX =1;
        for(int i=2;i<=N;i++){
            if(distance[MAX]<distance[i])
                MAX=i;
        }
        distance = new int[N+1];
        visited = new boolean[N+1];
        BFS(MAX);
        Arrays.sort(distance);
        System.out.println(distance[N]);
    }
    //BFS 구현
    private static void BFS(int index){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(index);
        visited[index] = true;
        while(!queue.isEmpty()){
            //큐에서 하나 꺼내기
            int now_node = queue.poll();
            for(Edge i:array[now_node]) {
                int e = i.e;
                int v = i.value;
                if(!visited[e]){
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[now_node]+v; //distance 배열 업데이트
                }
            }
        }
    }
}
class Edge{ //Edge 클래스 -> 노드의 번호와 간선의 가중치 값을 저장
    int e;
    int value;
    public Edge(int e, int value){
        this.e = e;
        this.value = value;
    }

}
