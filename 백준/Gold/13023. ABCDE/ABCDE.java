import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
로직 -> DFS 사용
문제에서 요구하고 있는 A,B,C,D,E 의 관계는 재귀함수의 형태와 비슷하다.
주어진 모든 노드에 DFS를 수행하고 재귀의 깊이가 5이상 (5개의 노드가 재귀 형태로 연결)이면 1을 출력,
아니면 0을 출력

 */
public class Main {
    static int N;   //노드의 개수
    static int M;   //엣지의 개수
    static boolean visited[];   //방문 기록 저장 배열
    static ArrayList<Integer>[]A;   //그래프 데이터 저장 인접 리스트
    static boolean arrive;          //도착 확인 변수

    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   //개수 입력
        M = Integer.parseInt(st.nextToken());
        //사용할 배열 등 초기화
        visited = new boolean[N];
        A = new ArrayList[N];
        //A 인접 리스트에 그래프 데이터 저장하기
        for(int i=0;i<N;i++){
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
        //DFS 실행
        for(int i=0;i<N;i++){
            DFS(i,1); //depth 1부터 시작..
            if(arrive)
                break;
        }
        if(arrive) System.out.println("1");
        else System.out.println("0");
    }
    public static void DFS(int now, int depth){
        if(depth==5 ||arrive) {
            arrive = true;
            return;
        }
        visited[now] = true;
        for(int i:A[now]){
            if(!visited[i]){
                DFS(i,depth+1);
            }
        }
        visited[now]=false;
    }
}
