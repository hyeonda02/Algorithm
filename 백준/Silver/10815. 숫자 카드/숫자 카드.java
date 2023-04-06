import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[] data;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data= new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(data);
		M = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			boolean find =false;
			int target = Integer.parseInt(st.nextToken()); 
			int start = 0;
			int end = data.length-1;
			
			while(start<=end) {
				int mid = (start+end)/2;
				int midValue = data[mid];
				if(midValue>target) {
					end = mid-1;
				}else if(midValue<target) {
					start = mid+1;
				}else {
					//탐색 성공
					sb.append(1).append(" ");
					find = true;
					break;
				}
			}
			if(find==false) {
				sb.append(0).append(" ");
			}
			
		}
		System.out.println(sb);
	}

}
