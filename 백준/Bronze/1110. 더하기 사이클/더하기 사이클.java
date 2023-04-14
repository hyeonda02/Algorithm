
//1110-사이클 더하기
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int N = scanner.nextInt();
		scanner.close();
		
		int copy=N;
		int cycle=0;
		int N2=0;
		if(N<=99&&N>=0) {
			for(;;) {
				N2=((N%10)*10)+((N/10)+(N%10))%10;
				cycle++;
				
				if(copy==N2) {
					System.out.println(cycle);
					break;
				}
				N=N2;
			}
		}
	}
}
