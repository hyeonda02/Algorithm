import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    //p9359 - 서로소
    static List<Long> getPrimeFactors(long n) {
        List<Long> factors = new ArrayList<>();
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors;
    }

    static long countMultiples(long x, long n) {
        if (x < 1) return 0;
        List<Long> factors = getPrimeFactors(n);
        int factorCount = factors.size();
        long count = 0;

        for (int i = 1; i < (1 << factorCount); i++) {
            long product = 1;
            int sign = -1;
            for (int j = 0; j < factorCount; j++) {
                if ((i & (1 << j)) != 0) {
                    product *= factors.get(j);
                    sign *= -1;
                }
                if (product > x) break;
            }
            count += sign * (x / product);
        }

        return count;
    }

    static long countCoprimes(long A, long B, long N) {
        long countInB = B - countMultiples(B, N); 
        long countInA = (A - 1) - countMultiples(A - 1, N); 
        return countInB - countInA;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            long N = Long.parseLong(st.nextToken());
            System.out.println("Case #" + i + ": " + countCoprimes(A, B, N));
        }
    }
}
