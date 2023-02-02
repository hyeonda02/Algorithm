import java.util.Scanner;
import java.util.Arrays;
//1940  주몽
public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int N=scanner.nextInt();
		int M=scanner.nextInt();
		int[] Arr=new int[N];
		for(int i=0;i<N;i++) {
			Arr[i]=scanner.nextInt();
		}
		scanner.close();
		Arrays.sort(Arr);
		int count=0;
		int i=0;
		int j=N-1;
		while(i<j) {
			if(Arr[i]+Arr[j]<M) {
				i++;
			}
			else if(Arr[i]+Arr[j]>M) {
				j--;
			}
			else {
				count++;
				i++;
				j--;
			}
		}
		System.out.println(count);
	}
}
