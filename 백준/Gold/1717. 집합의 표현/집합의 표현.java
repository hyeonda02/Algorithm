import java.util.Scanner;

public class Main {
    //1717 집합 표현하기 0: union 연산, 1:find 연산
    static int n,m,a,b,question;
    static int parent[];
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        parent = new int[n+1];
        for(int i=1;i<n+1;i++){
            parent[i] = i;
        }
        for(int i=0;i<m;i++){
            question = scanner.nextInt();
            a = scanner.nextInt();
            b = scanner.nextInt();
            if(question==0){
                //union-find 연산 실행
                union(a,b);
            }else{
                if(same(a,b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
    private static void union(int a,int b){
        a = find(a);
        b = find(b);
        if(a!=b) parent[b]=a;

    }
    private static int find(int a){
        if(a==parent[a]) return a;
        //시간 복잡도 줄이기 위해 경로 압축 실행
        else return parent[a]=find(parent[a]);
    }
    private static boolean same(int a, int b){
        a = find(a);
        b = find(b);
        if(a==b) return true;
        else return false;
    }
}
