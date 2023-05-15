
//8958 -OX퀴즈
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int test = scanner.nextInt();
		for(int i=0;i<test;i++) {
			
			String answer = scanner.next();
			int score =0,add=0;
			
			for(int j=0;j<answer.length();j++) {
					if(answer.charAt(j)=='O') { 
						add++;
						score+=add;
					}
					else 
						add=0;
				}
				System.out.println(score);
			}
		scanner.close();
		
		}
}

