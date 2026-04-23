import java.util.*;

public class Main {
    public static int[] primeArr;

    public static void checkPrime(){
        for(int i=2;i<primeArr.length;i++){
            if(primeArr[i]!=0) continue;

            for(int j=i+i;j<primeArr.length;j+=i){
                primeArr[j] = 1;
            }
        }

    }
    public static int sumPrime(int a, int b){
        int sum = 0;
        for(int i=a;i<=b;i++){
            if(primeArr[i]==0) sum+=i;
        }
        return sum;

    }
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        primeArr = new int[B+1];
        Arrays.fill(primeArr,0);

        checkPrime();
        System.out.println(sumPrime(A,B));

    }
}