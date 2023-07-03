import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,first,second;
    static ArrayList<ArrayList<Integer>> arr;
    static Queue<Integer>queue;
    static int[] indegree;
    static int[] buildTime;
    static int[] result;

    public static void main(String[]args)throws IOException {
        //1516, 게임 개발
        //문제의 조건을 보면 위상정렬을 이용해야 된다는 것을 알 수 있다..
        //그러나 각 건물을 짓는 "최소시간"을 출력해야 하기에,
        //자기 자신을 짓는데 걸리는 시간을 저장하는 배열도 필요할 것 같다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        for(int i=0;i<=N;i++){
            arr.add(new ArrayList<>());
        }
        indegree = new int[N+1];
        buildTime = new int[N+1];
        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            buildTime[i] = Integer.parseInt(st.nextToken());
            while(true){
                int preBuild = Integer.parseInt(st.nextToken());
                if(preBuild==-1) break;
                arr.get(preBuild).add(i);
                indegree[i]++;
            }
        }
        //위상 정렬
        queue = new LinkedList<>();
        for(int i=1;i<=N;i++){
            if(indegree[i]==0) queue.offer(i);
        }
        result= new int[N+1];
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int next:arr.get(now)){
                indegree[next]--;
                result[next] = Math.max(result[next],result[now]+buildTime[now]);
                if(indegree[next]==0)
                    queue.offer(next);
            }
        }
        for(int i=1;i<=N;i++){
            System.out.println(result[i]+buildTime[i]);
        }
    }
}
