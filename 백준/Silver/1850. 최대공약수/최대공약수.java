import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long result = gcd(A, B);
        for (int i = 0; i < result; i++) {
            bw.write("1");
        }
        bw.flush();
        bw.close();

    }

    private static long gcd(long a, long b) {
        if (b==0) return a;
        else return gcd(b, a % b);
    }
}
