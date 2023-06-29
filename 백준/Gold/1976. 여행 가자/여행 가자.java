import java.util.Scanner;

public class Main {
    //p1976 여행 가자
    //도시들 간의 연결 유무가 인접 행렬로 표현되어 있다.
    static int N,M;
    static int[][] city;
    static int[] rout;
    public static int[] parent; //union연산 정보 저장할 배열~
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        city = new int[N+1][N+1];
        rout = new int[M+1];
        parent = new int[N+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                city[i][j] = scanner.nextInt();
            }
        }
        //도시 계획 저장
        for(int i=1;i<M+1;i++){
            rout[i] = scanner.nextInt();
        }

        for(int i=1;i<N+1;i++){
            parent[i] =i;
        }
        //인접 행렬 보면서 union 연산 실행
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(city[i][j]==1) union(i,j);
            }
        }
        //계획된 도시들이 이어져 있는지 확인 -> YES or No
        int index = find(rout[1]);
        for(int i=2;i<rout.length;i++){
            if(index!=find(rout[i])){
                System.out.println("NO"); return;
            }
        }
        System.out.println("YES");
    }
    private static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b) parent[b] = a;

    }
    private static int find(int a){
        if(a==parent[a]) return a;
        //경로 압축
        else return parent[a] = find(parent[a]);
    }
}
