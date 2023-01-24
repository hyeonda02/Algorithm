import java.io.*;
import java.util.Arrays;
//통계학
public class Main {
	static int N;
	static int[] Data;
	public static void main(String[] args)throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		Data = new int[N];
		double sum=0;
		for(int i=0;i<N;i++) {
			Data[i] = Integer.parseInt(bf.readLine());
			sum+=Data[i];
		}
		Arrays.sort(Data);;
		//최빈값
		int count=0;
		int max = -1;
		int mod = Data[0];
		boolean check = false;
		for(int i=0;i<N-1;i++) {
			if(Data[i]==Data[i+1])
				count++;
			else
				count=0;
			if(max<count) {
				max = count;
				mod = Data[i];
				check = true;
			}else if(max==count&&check==true) {
				mod = Data[i];
				check = false;
			}
		}
		System.out.println(Math.round(sum/N));	//평균
		System.out.println(Data[(N-1)/2]);		//중앙값
		System.out.println(mod);					//최빈값
		System.out.println(Data[N-1]-Data[0]);	//범위(최대-최소)
		
	}
}
