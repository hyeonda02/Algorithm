
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b=scanner.nextInt();
		
		scanner.close();
		
		if(a>=-10000&&a<=10000&&b>=-10000&&b<=10000) {
			if(a>b)
				System.out.println(">");
			else if(a<b)
				System.out.println("<");
			else
				System.out.println("==");
			
		}
		
	}
}
