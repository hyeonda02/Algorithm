
import java.util.*;
import java.io.*;
public class Main {
	static int N;
	static int[] data,temp;
	public static long result;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N+1];
		temp = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		result =0;
		merge(1,N);
		System.out.println(result);
	}
	//Merge Sort
	private static void merge(int s, int e) {
		if(e-s<1)	
			return;
		int m = s+(e-s)/2;
		merge(s,m);
		merge(m+1,e);
		for(int i=s;i<=e;i++) {
			temp[i] = data[i];
		}
		int k = s;
		int index1 = s;
		int index2= m+1;
		//두 그룹 병합하는 로직
		while(index1<=m&& index2<=e) {
			if(temp[index1]>temp[index2]) {
				data[k] = temp[index2];
				result = result+(index2-k);
				k++;
				index2++;
			}else {
				data[k] = temp[index1];
				k++;
				index1++;
			}
		}
		//한쪽 그룹이 먼저 끝났다면, 나머지 그룸의 요소들 차례대로 넣어주기
		while(index1<=m) {
			data[k] = temp[index1];
			k++;
			index1++;
		}
		while(index2<=e) {
			data[k] = temp[index2];
			k++;
			index2++;
		}
	}

}
