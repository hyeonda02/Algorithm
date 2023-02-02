import java.util.*;
import java.io.*;
//ATM
public class Main {
	static int N;
	static int []data;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N =Integer.parseInt(br.readLine());
		data = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		insert_Sort();
		print();
		
	}
	public static void insert_Sort() {
		for(int i=1;i<N;i++) {
			int insert_point =i;
			int insert_value=data[i];
			
			for(int j=i-1;j>=0;j--) {
				if(data[j]<data[i]) {
					insert_point = j+1;
					break;
				}
				if(j==0) {
					insert_point = 0;
				}
			}
			for(int j=i;j>insert_point;j--) {
				data[j] = data[j-1];
			}
			data[insert_point] = insert_value;
			
		}
	}
	public static void print() {
		//합 배열 만들기
		for(int i=1;i<N;i++) {
			data[i] +=data[i-1];
		}
		int sum=0;
		for(int i=0;i<N;i++) {
			sum+=data[i];
		}
		System.out.println(sum);
	}
}
