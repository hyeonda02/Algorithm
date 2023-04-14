
//4344-평균은 넘겠지
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		
		int test_case=scanner.nextInt();
		
		for(int i=0;i<test_case;i++) {
			int Student = scanner.nextInt();
			int[] score=new int[Student];
			double avg=0;
			
			for(int j=0;j<Student;j++) {
				score[j]=scanner.nextInt();
				avg+=score[j];
			}
			avg=avg/Student;
			double avgStudent=0;
			
			for(int j=0;j<Student;j++) {
				if(score[j]>avg)
					avgStudent++;
			}
			
			System.out.printf("%.3f%%"+"%n",(avgStudent/Student)*100);
		}
		scanner.close();	
	}	
}


