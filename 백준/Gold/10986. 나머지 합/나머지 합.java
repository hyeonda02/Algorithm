import java.util.Scanner;
import java.io.IOException;
//p10986
public class Main {
	public static void main(String[] args) throws IOException{
		Scanner scanner=new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		long[] same = new long[M];
		long[] SumArrays = new long[N];
		long  Answer=0;
		SumArrays[0]=scanner.nextInt();
		for(int i=1;i<N;i++) {
			SumArrays[i]=SumArrays[i-1]+scanner.nextInt();
		}
		for(int i=0;i<N;i++) {
			int remainder = (int)(SumArrays[i]%M);
			if(remainder==0) Answer++;
			same[remainder]++;
			
		}
		for(int i=0;i<M;i++) {
			if(same[i]>1)
				Answer=Answer+(same[i]*(same[i]-1)/2);
		}
		
		System.out.println(Answer);
        scanner.close();
	}
}
