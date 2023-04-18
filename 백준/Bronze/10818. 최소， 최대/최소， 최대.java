//10818 배열
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		int num = scanner.nextInt();
		if(num>=1&&num<=1000000) {
			int[] arr1=new int[num];
			
			for(int i=0;i<num;i++) {
				arr1[i]=scanner.nextInt();
			}
			scanner.close();
			int max=arr1[0],min=arr1[0];
			for(int i=0;i<num;i++) {
				if(max<=arr1[i]) max=arr1[i];
				
				if(min>=arr1[i]) min=arr1[i];
			}
			System.out.println(min+" "+max);
			
		}
		
	
	}
}
