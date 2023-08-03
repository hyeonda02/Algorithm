import java.util.Scanner;
//11720
public class Main {
	public static void main(String [] args) {
		Scanner scanner=new Scanner(System.in);
		int N=scanner.nextInt();
		String SNumbers=scanner.next();
		char[] CNumbers=SNumbers.toCharArray();
		int sum=0;
		for(int i=0;i<CNumbers.length;i++) {
			sum+=CNumbers[i]-'0';
		}
		System.out.println(sum);
		scanner.close();
		
	}
}
