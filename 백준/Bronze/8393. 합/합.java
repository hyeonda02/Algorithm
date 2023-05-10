
//8393-합
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n =scanner.nextInt();
		int sum=0;
		scanner.close();
		if(n>=1&&n<=10000) {
			for(int i=1;i<=n;i++) {
				sum+=i;
			}
		}
		System.out.println(sum);
	}
}
