
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
            //전제 비율에 대한 최소 공배수 값을 저장 -> 이 값을 후에 D 값에 저장하고, DFS를 통해 
            //q/p 곱하는 계산(즉 비율 계산)을 해서, 각 노드의 값을 저장한다. 
            lcm *= p*q/gcd(p,q);
        }
        D[0] = lcm;
        DFS(0);
        
        //각 노드의 값을 모든 노드의 최대공약수로 나눔 ( 최소 질량 구하기 위함 )
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
                // 각 노드의 값을 이전 노드의 값과의 비율을 계산을 통해 계산하고 저장
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
