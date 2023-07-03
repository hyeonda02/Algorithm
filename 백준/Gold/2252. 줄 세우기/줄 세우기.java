import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N,M,first,second;
    static Queue<Integer> queue;
    static int[] indegree;
    static ArrayList<ArrayList<Integer>> arr;
    public static void main (String[]args)throws IOException {
    //2252 줄세우기, 위상정렬
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        arr = new ArrayList<>();
        queue = new LinkedList<>();
        for(int i=0;i<=N;i++){
            arr.add(new ArrayList<>());
        }
        indegree = new int[N+1];
        for(int i=0;i<M;i++){
            first = scanner.nextInt();
            second = scanner.nextInt();
            arr.get(first).add(second);
            indegree[second]++;
        }
        for(int i=1;i<N+1;i++){
            if(indegree[i]==0) queue.offer(i);
        }
        while(!queue.isEmpty()){
            int now = queue.poll();
            System.out.println(now+" ");
            for(int next:arr.get(now)){
                indegree[next]--;
                if(indegree[next]==0)
                    queue.offer(next);
            }
        }
    }
}
