import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    private static int[] parent;
    private static ArrayList<Integer>[] party;
    private static int[] trueP;
    public static int result;
    private static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b){
            parent[b] = a;
        }
    }
    private static int find(int a) {
        if (a==parent[a]) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        result =0;
        int N = Integer.parseInt(st.nextToken());
        int M =  Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        //진실 아는 사람 저장
        trueP = new int[T];
        for(int i=0;i<T;i++){
            trueP[i] = Integer.parseInt(st.nextToken());
        }
        //파티 정보, 같은 파티 사람 union
        party = new ArrayList[M];
        for(int i=0;i<M;i++){
            party[i] = new ArrayList<Integer>();
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            for(int j=0;j<size;j++){
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        //union 초기화
        parent = new int[N+1];
        for(int i=0;i<=N;i++){
            parent[i] = i;
        }
        for(int i=0;i<M;i++){
            int firstPeople = party[i].get(0);
            for(int j=1;j<party[i].size();j++){
                union(firstPeople,party[i].get(j));
            }
        }
        for(int i=0;i<M;i++){
            boolean isPossible = true;
            int cur = party[i].get(0);
            for(int j=0;j<trueP.length;j++){
                if(find(cur)==find(trueP[j])){
                    isPossible = false;
                    break;
                }
            }
            if(isPossible) result++;
        }
        System.out.println(result);
    }
}
