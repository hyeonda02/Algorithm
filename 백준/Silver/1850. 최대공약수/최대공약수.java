import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최대 공약수, 유클리드호제법 사용
 */
public class Main {
    static Long A;
    static Long B;
    private static Long gcd(Long A, Long B ) {
        if(B ==0) return A;
        else return gcd(B,A%B);
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < gcd(A,B); i++) {
            sb.append("1");
        }
        System.out.println(sb.toString());

    }
}
