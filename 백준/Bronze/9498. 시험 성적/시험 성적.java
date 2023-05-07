import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		scanner.close();
		char score;
		if(input>=90)
			score='A';
		else if(input>=80)
			score='B';
		else if(input>=70)
			score='C';
		else if(input>=60)
			score='D';
		else
			score='F';
			
		System.out.println(score);
		
		 
	}
	
}

