import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //틀린 이유 :  시간 초과.. -> dp 사용
    static int MAX = 1000;
    static int[] dp = new int[MAX + 1];
    public static int gcd(int x, int y) {
        if(y==0) return x;
        return gcd (y, x % y);
    }
    public static void solution() {
        dp[1] = 3;
        for (int i = 2; i <= MAX; i++) {
            int answer =0;
            for (int j = 1; j < i; j++) {
                if(gcd(i,j)==1){
                    answer++;
                }
            }
            dp[i] = answer*2 +dp[i-1];
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        solution();
        for (int i = 0; i < C; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(dp[N]);
        }
    }

}