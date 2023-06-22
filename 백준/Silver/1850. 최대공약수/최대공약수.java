import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[]args)throws Exception{
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long result = gcd(a,b);
        for(int i=0;i<result;i++){
            bw.write("1");
        }
        bw.flush();
        bw.close();
    }
    private static long gcd(long a, long b){
        if(b==0) return a;
        else return gcd(b,a%b);
    }
}
