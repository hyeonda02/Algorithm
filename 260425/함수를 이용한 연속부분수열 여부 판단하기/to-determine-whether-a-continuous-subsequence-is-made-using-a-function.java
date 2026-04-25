import java.util.Scanner;
public class Main {
    public static boolean solution(int[] a, int[] b){
        if(a.length<b.length)return false; 
        String strA=",";
        String strB=",";
        for(int i=0;i<a.length;i++){
            strA+=a[i]+",";
        }
        for(int i=0;i<b.length;i++){
            strB+=b[i]+",";
        }
        if(strA.contains(strB)) return true;
        return false;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int[] a = new int[n1];
        int[] b = new int[n2];
        for (int i = 0; i < n1; i++)
            a[i] = sc.nextInt();
        for (int i = 0; i < n2; i++)
            b[i] = sc.nextInt();
        // Please write your code here.
        if(solution(a,b)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}