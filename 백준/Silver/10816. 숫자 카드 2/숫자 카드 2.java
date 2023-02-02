
import java.util.*;
import java.io.*;
//숫자 카드2
public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			int find = Integer.parseInt(st.nextToken());
			sb.append(upperBound(arr,find)-lowerBound(arr,find)).append(" ");
			
		}
		System.out.println(sb);
		
	}
	public static int lowerBound(int[] arr,int find) {
		int lo =0;
		int hi = arr.length;
		while(lo<hi) {
			int mid = (lo+hi)/2;
			if(find<=arr[mid]) {
				hi = mid;
			}else {
				lo = mid+1;
			}
		}
		return lo;
	}
	public static int upperBound(int[] arr,int find) {
		int lo =0;
		int hi = arr.length;
		while(lo<hi) {
			int mid = (lo+hi)/2;
			if(find<arr[mid]) {
				hi=mid;
			}else{
				lo = mid+1;
			}
		}
		return lo;
	}
}
