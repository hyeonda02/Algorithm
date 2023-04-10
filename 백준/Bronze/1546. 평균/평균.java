
//8958 -OX퀴즈
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		int N =scanner.nextInt();
		if(N<=1000) {
			double[] score= new double[N];
			for(int i=0;i<N;i++) {
				score[i]=scanner.nextDouble();
			}
			double max=score[0];
			for(int i=0;i<N;i++) {
				if(max<score[i])
					max=score[i];
			}
			double avg=0;
			for(int i=0;i<N;i++) 
				avg+=score[i]/max*100;
			System.out.println(avg/(double)N);
			}
		scanner.close();
		}
	}


