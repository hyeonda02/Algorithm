import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int m;
    private static int a;
    private static int b;
    private static int[] parent;
    private static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b){
            parent[b] = a;
        }
    }
    private static int find(int a){
        if(parent[a] == a){
            return a;
        }else{
            //주의 -> 경로 압축하면 시간 복잡도 감소됨
            return parent[a] = find(parent[a]);
        }
    }
    private static void isSame(int a, int b){
        a = find(a);
        b = find(b);
        if(a==b){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for(int i=1;i<parent.length;i++){
            parent[i] = i;
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int check = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(check == 0){
                union(a, b);
            }else{
                isSame(a, b);
            }
        }
    }
}