import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;

    public static void solution(int[] arr){
        for(int i=0;i<arr.length;i++){
            arr[i] = Math.abs(arr[i]);
        }

    }

    public static void main(String[] args) throws Exception{
        // Please write your code here.
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine()); 
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i=0;i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution(arr);

        for(int i=0; i<N;i++){
            System.out.print(arr[i]+" ");
        }

    }
}