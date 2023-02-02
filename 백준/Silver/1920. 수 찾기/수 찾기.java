import java.io.*;
import java.util.*;
//수 찾기
public class Main {
	static int N;
	static int M;
	static int[] data;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(data);
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			boolean find = false;
			int target = Integer.parseInt(st.nextToken());
			int start= 0;
			int end = data.length-1;
			
			while(start<=end) {
				int mid = (start+end)/2;
				int midValue = data[mid];
				
				if(midValue>target) {
					end = mid-1;
				}else if(midValue<target) {
					start = mid+1;
				}else {
					sb.append(1).append("\n");
					find = true;
					break;
				}
			}
			if(!find)
				sb.append(0).append("\n");
		}
		System.out.println(sb);
	}
}
