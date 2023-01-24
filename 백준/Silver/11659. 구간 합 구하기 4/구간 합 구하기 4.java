import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;

//11659
public class Main {
	public static void main(String [] args)throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());
		
		int M=Integer.parseInt(stringTokenizer.nextToken());
		int N=Integer.parseInt(stringTokenizer.nextToken());
		
		long[] Arrays = new long[M+1];
		stringTokenizer=new StringTokenizer(bf.readLine());
		
		for(int i=1;i<M+1;i++) {
			Arrays[i]=Arrays[i-1]+Integer.parseInt(stringTokenizer.nextToken());
		}
		for(int a=0;a<N;a++) {
			stringTokenizer=new StringTokenizer(bf.readLine());
			int i =Integer.parseInt(stringTokenizer.nextToken());
			int j = Integer.parseInt(stringTokenizer.nextToken());
			System.out.println(Arrays[j]-Arrays[i-1]);
		}
		
	}
}
