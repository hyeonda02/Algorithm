import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Result {
        long gcd;
        long x;
        long y;

        public Result(long gcd, long x, long y) {
            this.gcd = gcd;
            this.x = x;
            this.y = y;
        }
    }

    public static Result exEuclidean(long a, long b) {
        if (b == 0) {
            return new Result(a, 1, 0);
        }
        Result next = exEuclidean(b, a % b);
        long gcd = next.gcd;
        long x = next.y;
        long y = next.x - (a / b) * next.y;
        return new Result(gcd, x, y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long A = Long.parseLong(st.nextToken());

        long B = (N - A) % N;
        System.out.print(B + " "); 

        Result result = exEuclidean(A, N);
        if (result.gcd != 1) {
            System.out.print(-1); 
        } else {
            long multiplicativeInverse = (result.x % N + N) % N;
            System.out.println(multiplicativeInverse);
        }
    }
}
