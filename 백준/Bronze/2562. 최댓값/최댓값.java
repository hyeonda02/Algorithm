
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		int[] Arr1=new int[9];
		int num;
		for(int i=0;i<9;i++) {
			num=scanner.nextInt();
			if(num<100) {
				Arr1[i]=num;
			}
		}
		scanner.close();
		int max=Arr1[0];
		int pos=0;
		for(int i=0;i<9;i++) {
			if(max<=Arr1[i]) {
				max=Arr1[i];
				pos=i+1;
			}
		}
		System.out.println(max);
		System.out.println(pos);
	}
}
