import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
	int A,B;
	int C;
	Scanner scanner = new Scanner(System.in);
	A=scanner.nextInt();
	B=scanner.nextInt();
	C=scanner.nextInt();
	scanner.close();
	if(C<=1000&&C>=0) {
		if(A>=0&&A<=23&&B>=0&&B<=59) {
			B+=C;
			if(B>=60) {
				A=A+(B/60);
				B%=60;
				if(A>=24)
					A-=24;
			}
			System.out.println(A+" "+B);
		}
	}
	}
}
