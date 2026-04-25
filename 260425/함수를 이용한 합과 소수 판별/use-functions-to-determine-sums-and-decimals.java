import java.util.*;

public class Main {
    static int[] arr;
    public static void checkPrime(){
        for(int i=2;i<arr.length;i++){
            if(arr[i]==1) continue;
            for(int j=i+i;j<arr.length;j+=i){
                arr[j]=1;
            }
        }
    }
    public static boolean checkSum(int a){
        int sum=0;
        while(a!=0){
            sum+=a%10;
            a/=10;
        }
        if(sum%2==0) return true;
        return false;

    }
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int result = 0;
        arr = new int[B+1];
        checkPrime();
        for(int i=A;i<=B;i++){
            if(arr[i]==1||!checkSum(i)) continue;
            result++;           
        }
        System.out.println(result);

    }
}