
import java.util.*;
import java.io.*;
public class Main {
	static int N;
	static String[][]data; 
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		data = new String[N][2];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			data[i][0] = st.nextToken();	//나이
			data[i][1]=st.nextToken();		//이름
		}
		Arrays.sort(data,new Comparator<String[]>() {
			public int compare(String[] s1, String[] s2) {
				return Integer.parseInt(s1[0])-Integer.parseInt(s2[0]);
			}
		});
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(data[i][0]).append(" ").append(data[i][1]).append("\n");
		}
		System.out.println(sb);
		
	}
}
