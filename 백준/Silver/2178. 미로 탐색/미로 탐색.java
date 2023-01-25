import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//미로 탐색
public class Main {
    //상하좌우를 탐색하기 위한 배열 선언하기
    static int[] dx={0,1,0,-1};
    static int[] dy ={1,0,-1,0};
    static int N;
    static int M;
    static int[][] array;
    static boolean[][] visited;
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        array = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j=0;j<M;j++){
                array[i][j] = Integer.parseInt(line.substring(j,j+1));
            }
        }
        BFS(0,0);
        System.out.println(array[N-1][M-1]);
    }
    public static void BFS(int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i,j});
        visited[i][j] = true;
        while(!queue.isEmpty()){
            int now[] = queue.poll();
            for(int k=0;k<4;k++){
                int x = now[0]+dx[k];
                int y = now[1]+dy[k];
                //좌표 유효성 검사
                if(x>=0&&y>=0&&x<N&&y<M){
                    if(array[x][y]!=0&&!visited[x][y]){
                        visited[x][y] = true;
                        array[x][y]=array[now[0]][now[1]]+1;
                        queue.add(new int[]{x,y});
                    }
                }
            }
        }
    }
}
