
//10950 A+B-3
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		int test_case = scanner.nextInt();
		for(int i=1;i<=test_case; i++) {
			int A=scanner.nextInt();
			int B=scanner.nextInt();
				if(0<A&&B<10) {
				System.out.println("Case #"+ i +": "+(A+B));
				}
		}
		scanner.close();
		
		
	}	
}


