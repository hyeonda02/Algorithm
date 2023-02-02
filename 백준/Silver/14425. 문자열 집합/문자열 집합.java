
import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static int M;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Map<String,Integer> map = new HashMap<>();
		for(int i=0;i<N;i++) {
			map.put(br.readLine(),0);
		}
		int count =0;
		for(int i=0;i<M;i++) {
			if(map.containsKey(br.readLine())) count++;
		}
		System.out.println(count);
		
		
	}
}
