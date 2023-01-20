import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.IOException;
public class Main {
	public static void main(String[] args)throws NumberFormatException, IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(bf.readLine());
		long[] Array=new long[N];
		StringTokenizer st=new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) {
			Array[i]=Long.parseLong(st.nextToken());
		}
		Arrays.sort(Array);
		//좋은 수 개수 확인
		int count = 0;
		for(int i=0;i<N;i++) {
			long result=Array[i];
			int a=0;
			int b=N-1;
			//a와b가 교차되는 순간 종료
			while(a<b) {
				if(Array[a]+Array[b]==result) {
					if(a!=i&&b!=i) {
						count++; break;
					}
					else if(a==i) {
						a++;
					}
					else if(b==i) {
						b--;
					}
				}
				else if(Array[a]+Array[b]>result) {
					b--;
				}
				else {
					a++;
				}
			}
		}
		System.out.println(count);
		bf.close();
	}
}
