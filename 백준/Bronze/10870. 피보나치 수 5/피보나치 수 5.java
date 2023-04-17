import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		int N=scanner.nextInt();
		int result=fibo(N);
		System.out.println(result);
		scanner.close();
		
	}
	public static int fibo(int number) {
		if(number==0) return 0;
		else if(number==1) return 1;
		else
			return fibo(number-2)+fibo(number-1);	
	}
}