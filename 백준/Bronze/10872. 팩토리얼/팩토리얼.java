import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		int N=scanner.nextInt();
		int result=factorial(N);
		System.out.println(result);
		
	}
	public static int factorial(int number) {
		if(number==0) return 1;
		else
			return number*factorial(number-1);
	}

}