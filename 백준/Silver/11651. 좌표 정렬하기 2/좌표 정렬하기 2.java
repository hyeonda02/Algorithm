import java.io.*;
import java.util.*;
//좌표 정렬2
public class Main {
	static int N;
	static int[][] data;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data= new int[N][2];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			data[i][1]=Integer.parseInt(st.nextToken());
			data[i][0]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(data,(e1,e2)->{
			if(e1[0]==e2[0]) {
				return e1[1]-e2[1];
			}else {
				return e1[0]-e2[0];
			}
		});
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(data[i][1]+" "+data[i][0]).append('\n');
		}
		System.out.println(sb);
		
	}
}
