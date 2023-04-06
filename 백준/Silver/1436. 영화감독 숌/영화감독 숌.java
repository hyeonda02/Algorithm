import java.util.Scanner;
//영화 감독 숌
public class Main {
	public static int N;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		scanner.close();
		Solution();
	}
	public static void Solution() {
		int Number = 666;
		int Count = 1;
		
		while(true) {
			if(N==Count) {
				System.out.println(Number);
				break;
			}
			Number++;
			if(String.valueOf(Number).contains("666"))
				Count++;
		}
	}
}
