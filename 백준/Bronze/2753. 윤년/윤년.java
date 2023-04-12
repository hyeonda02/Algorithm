//2753 윤년
import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner scanner =new Scanner(System.in);
		int in =scanner.nextInt();
		
		scanner.close();
		if(in>=1&&in<=4000) {
			if(in%4==0) {
				if(in%100!=0) System.out.println("1");
				else if(in%400==0) System.out.println("1");
				else System.out.println("0");
			}
			else System.out.println("0");
		}
		else System.out.println("0");
	}
	
}