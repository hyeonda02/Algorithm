import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] remain= new int[42];
		for(int i=0;i<10;i++) {
			int number=scanner.nextInt();
			number=number%42;
			remain[number]+=1;
		}
		int count=0;
		for(int i=0;i<42;i++) {
			if(remain[i]!=0)
				count++;
		}
		
		System.out.println(count);
		scanner.close();
	}
}
