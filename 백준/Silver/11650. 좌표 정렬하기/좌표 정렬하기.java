import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static int[][]Data;
	public static void main(String[] args)throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader (System.in));
		N = Integer.parseInt(bf.readLine());
		Data = new int[N][2];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			Data[i][0] = Integer.parseInt(st.nextToken());
			Data[i][1] = Integer.parseInt(st.nextToken());
		}
		Solution();
	}
	public static void Solution() {
		Arrays.sort(Data,(Data1,Data2)->{
			if(Data1[0]==Data2[0])
				return Data1[1]-Data2[1];
			else
				return Data1[0]-Data2[0];
		});
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++)
			sb.append(Data[i][0]+" "+Data[i][1]).append("\n");
		System.out.println(sb);
			
	}
}
