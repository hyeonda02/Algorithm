import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static int k;
	static int Data[];
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		Data = new int[N];
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++)
			Data[i] = Integer.parseInt(st.nextToken());
		Solution();
	}
	//Bubble Sort
	public static void Solution() {
		for(int i=N-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				if(Data[j]>Data[j+1]) {
					int temp = Data[j];
					Data[j]=Data[j+1];
					Data[j+1]=temp;
				}
			}
		}
			System.out.println(Data[N-k]);
	}
}
