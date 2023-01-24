import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] Array = new int[N+1];
		st=new StringTokenizer(bf.readLine());
		for(int i=1;i<N+1;i++) {
			Array[i]=Array[i-1]+Integer.parseInt(st.nextToken());
		}
        int max = Array[K];
		for(int i=K;i<N+1;i++) {
			int j=i-K+1;
			int result = Array[i]-Array[j-1];
			if(max<result)
				max= result;
		}
		System.out.println(max);
	}
}
