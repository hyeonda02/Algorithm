
import java.util.*;
import java.io.*;
import java.lang.NumberFormatException;

public class Main {
	static int[] Checkarr;
	static int[] Myarr;
	static int Checksecret;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		int S=Integer.parseInt(st.nextToken());
		int P=Integer.parseInt(st.nextToken());
		int result=0;
		Checksecret=0;
		char[] A=new char[S];
		Checkarr=new int[4];
		Myarr=new int[4];
		A=bf.readLine().toCharArray();	
		st= new StringTokenizer(bf.readLine());
		for(int i=0;i<4;i++) {
			Checkarr[i]=Integer.parseInt(st.nextToken());
			if(Checkarr[i]==0)
				Checksecret++;
		}
		for(int i=0;i<P;i++) {
			Add(A[i]);
		}
		if(Checksecret==4) result++;
		for(int i=P;i<S;i++) {
			int j=i-P;
			Remove(A[j]);
			Add(A[i]);
			if(Checksecret==4)
				result++;
			
		}
		System.out.println(result);
		bf.close();
	}
	private static void Add(char c) {
		switch(c) {
			case('A'):
				Myarr[0]++;
			if(Myarr[0]==Checkarr[0])
				Checksecret++;
				break;
			
			case('C'):
				Myarr[1]++;
			if(Myarr[1]==Checkarr[1])
				Checksecret++;
				break;
			
			case('G'):
				Myarr[2]++;
			if(Myarr[2]==Checkarr[2])
				Checksecret++;
				break;
			
			case('T'):
				Myarr[3]++;
			if(Myarr[3]==Checkarr[3])
				Checksecret++;
				break;
			}
		}
	private static void Remove(char c) {
		switch(c) {
		case('A'):
			if(Myarr[0]==Checkarr[0])
				Checksecret--;
			Myarr[0]--;
			break;
		case('C'):
			if(Myarr[1]==Checkarr[1])
				Checksecret--;
			Myarr[1]--;
			break;
		case('G'):
			if(Myarr[2]==Checkarr[2])
				Checksecret--;
			Myarr[2]--;
			break;
		case('T'):
			if(Myarr[3]==Checkarr[3])
				Checksecret--;
			Myarr[3]--;
			break;
		}	
	}

}
