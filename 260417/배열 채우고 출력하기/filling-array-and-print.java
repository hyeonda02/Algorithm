import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args)throws Exception {
        // Please write your code here.
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        String[] arr = new String[10];

        for(int i=0;i<10;i++){
            arr[i] = st.nextToken();

        }

        for(int i=arr.length-1;i>=0;i--){
            System.out.print(arr[i]);
        
        }

    }
}