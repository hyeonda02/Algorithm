
//10950 A+B-3
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
	
		Scanner scanner =new Scanner(System.in);
		int N=scanner.nextInt();
		int X=scanner.nextInt();
		int[] Arrays=new int[N];
		for(int i=0;i<N;i++) {
			Arrays[i]=scanner.nextInt();
			if(X>Arrays[i])
				System.out.print(Arrays[i] +" ");
		}
		scanner.close();
	}	
}


