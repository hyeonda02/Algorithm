

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] primeList = isPrime(N);
        for (int i = M; i <= N; i++) {
            if(primeList[i]!=0){
                System.out.println(primeList[i]);
            }
        }
    }

    public static int[] isPrime(int N) {
        int[] list = new int[N + 1];
        for (int i = 2; i <=N; i++) {
            list[i] = i;
        }
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if(list[i]==0) continue;
            for (int j = i + i; j <= N; j += i) {
                list[j] = 0;
            }
        }
        return list;
    }
}
