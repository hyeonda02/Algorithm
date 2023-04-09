
import java.util.Scanner;
import java.util.Arrays;

public class Main {
	static int N,K;
	static int Answer=0;
	static int[] arrays;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		K = scanner.nextInt();
		
		arrays=new int[K];
		
		for(int i=0;i<K;i++) {
			arrays[i]=scanner.nextInt();
		}
		
		Arrays.sort(arrays);
		findMax(0);
		
		System.out.println(Answer);
		scanner.close();
		
	}
	static void findMax(int now) {

		if(now>N) return;
		
		if(Answer<=now) Answer=now;
		
		for(int i=K-1;i>=0;i--) {
			findMax(now*10+arrays[i]);
		}
	}
}
