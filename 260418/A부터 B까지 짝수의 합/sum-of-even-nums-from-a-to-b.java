import java.util.*;
import java.io.*;

public class Main {
    static int A;
    static int B;
    static int answer;

    public static void main(String[] args) throws Exception{
        // Please write your code here.
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        
        answer = 0;

        for(int i=A;i<=B;i++){
            if(i%2==0){
                answer +=i;
            }
        }
        System.out.println(answer);

    }
}