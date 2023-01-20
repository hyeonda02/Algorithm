import java.util.*;
import java.io.*;
public class Main {
	static char[][] StarArray;
	
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		int N = scanner.nextInt();
		scanner.close();
		StarArray = new char[N][N];
		Star(0,0,N,false);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(StarArray[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
		
	}
	static void Star(int x, int y, int N, boolean blank) {
		
		if(blank) {
			for(int i=x;i<x+N;i++) {
				for(int j=y;j<y+N;j++)
					StarArray[i][j]=' ';
			}
			return;
		}
		if(N==1) {
			StarArray[x][y]='*';
			return;
		}
		
		
		int size = N/3;
		int count=0;
		for(int i=x;i<x+N;i+=size) {
			for(int j=y;j<y+N;j+=size) {
				count++;
				if(count==5) Star(i,j,size,true);
				else Star(i,j,size,false);
			}
		}
	}
}
