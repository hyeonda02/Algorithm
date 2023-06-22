
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //p1033 칵테일
    static ArrayList<cNode>[] arr;
    static long lcm;
    static boolean visited[];
    static long D[];
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        arr = new ArrayList[N];
        visited = new boolean[N];
        D = new long[N];
        lcm =1;
        for(int i=0;i<N;i++){
            arr[i] = new ArrayList<cNode>();
        }
        for(int i=0;i<N-1;i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            arr[a].add(new cNode(b,p,q));
            arr[b].add(new cNode(a,q,p));
            lcm *= p*q/gcd(p,q);
        }
        D[0] = lcm;
        DFS(0);
        long mgcd = D[0];
        for(int i=1;i<N;i++){
            mgcd = gcd(mgcd,D[i]);
        }
        for(int i=0;i<N;i++){
            System.out.print(D[i]/mgcd+" ");
        }

    }
    private static long gcd(long a, long b){
        if(b==0) return a;
        else return gcd(b,a%b);
    }
    private static void DFS(int Node){
        visited[Node] = true;
        for(cNode i :arr[Node]){
            int next = i.getB();
            if(!visited[next]){
                D[next] = D[Node]*i.getQ()/i.getP();
                DFS(next);
            }
        }

    }
}
class cNode{
    int b;
    int p;
    int q;
    public cNode(int b, int p,int q){
        super();
        this.b=b;
        this.p=p;
        this.q=q;
    }
    public int getB(){
        return b;
    }
    public int getP(){
        return p;
    }
    public int getQ(){
        return q;
    }

}
