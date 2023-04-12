
//2741- N찍기
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N =scanner.nextInt();
		scanner.close();
		if(N<=100000&&N>=1) {
			for(int i=1;i<=N;i++) {
				System.out.println(i);
			}
		}
	}
}
