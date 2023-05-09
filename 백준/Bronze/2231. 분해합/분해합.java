import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int result=0;
		//방법 1 : 1부터 N까지 대입해보기
		for(int i=1;i<N;i++) {
			int number =i;
			int sum=0;
			while(number!=0) {
				sum+=number%10;//각 자리수 더하기
				number/=10;
			}
			if((sum+i)==N) {
				result=i;
				break;
			}
		}
		System.out.println(result);
	}
}