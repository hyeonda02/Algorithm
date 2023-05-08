import java.util.*;
import java.io.*;
public class Main {
	public static int N;
	public static int[][] Info;
	public static void main(String[] args)throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		//사람 수 입력
		N = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		
		Info = new int[N][2];
		
		//사람의 몸무게, 키 입력
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			Info[i][0] = Integer.parseInt(st.nextToken());
			Info[i][1] = Integer.parseInt(st.nextToken());
		}
		Solution();
	}
	public static void Solution() {
		for(int i=0;i<N;i++) {
			int grade=1;
			for(int j=0;j<N;j++) {
				if(i==j) continue;
				//키와 몸무게가 작을 경우 grade 증가
				if(Info[i][0]<Info[j][0]&&Info[i][1]<Info[j][1]) grade++;
			}
			System.out.println(grade);
		}
	}
}
