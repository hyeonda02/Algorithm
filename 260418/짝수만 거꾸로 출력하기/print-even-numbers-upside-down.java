import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int arr[];
    public static void main(String[] args)throws Exception {
        // Please write your code here.
 
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=N-1;i>=0;i--){
            if(arr[i]%2==0){
                System.out.print(arr[i]+" ");
            }
        }
    }
}