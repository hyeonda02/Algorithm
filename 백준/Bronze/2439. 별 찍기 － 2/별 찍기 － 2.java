
//10950 A+B-3
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
	
		Scanner scanner=new Scanner(System.in);
		int N =scanner.nextInt();
		scanner.close();
		for(int i=0;i<N;i++) {
			for(int j=N-1;j>i;j--) {
				System.out.print(' ');
			}
			for(int j=0;j<=i;j++) {
				System.out.print('*');
			}
			System.out.println();
		}
		
		
	}	
}


