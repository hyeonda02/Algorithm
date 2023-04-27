import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[]args) {
		int[] array = {1,1,2,2,2,8};
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		int[] inputArray = new int[6];
		for(int i=0;i<inputArray.length;i++) {
			inputArray[i] = scanner.nextInt();
		}
		for(int i=0;i<inputArray.length;i++) {
			int result=array[i]-inputArray[i];
			System.out.print(result+" ");
		}
		
	}
}
