import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int arr[];

    public static void main(String[] args)throws Exception {
        // Please write your code here.
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=0;i<N;i++){
            System.out.print((int)(Math.pow(arr[i],2))+" ");
        }

    }
}