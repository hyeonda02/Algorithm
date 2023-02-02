import java.util.*;
import java.io.*;

public class Main {
	public static int[][] Chess; //체스판
	public static int result=64; //최소 개수
	
	public static void main(String[] args)throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		//체스판 크기 
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Chess = new int[N][M];
		
		//체스판 "W"일 경우 1, "B" 일 경우 0
		for(int i=0;i<N;i++) {
			String str= bf.readLine();
			
			for(int j=0;j<M;j++) { 
				if(str.charAt(j)=='W')
					Chess[i][j]=1;
				else 
					Chess[i][j]=0;
			}
		}
		
		for(int i=0;i<N-7;i++) {
			for(int j=0;j<M-7;j++)
				Solution(i,j);
		}
		System.out.println(result);
	}
	public static void Solution(int x, int y) {
		int paint=Chess[x][y];	//첫번째 좌표의 색상
		int EndPoint_X= x+8;
		int EndPoint_Y = y+8;
		int count=0;
		for(int i=x;i<EndPoint_X;i++) {
			
			for(int j=y;j<EndPoint_Y;j++) {
				if(Chess[i][j]!=paint) count++;
				//비교 색상 바꾸기
				if(paint==1) paint=0;
				else if(paint==0) paint =1;
			}
			if(paint==1) paint =0;
			else if(paint==0) paint =1;
		}
		count = Math.min(count, 64-count);
		result = Math.min(result, count);
	}

}
