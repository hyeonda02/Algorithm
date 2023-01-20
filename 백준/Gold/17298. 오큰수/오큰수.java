import java.util.*;
import java.io.*;
public class Main {
	static int N;
	static int[] Data;
	public static void main(String[] args)throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		Data = new int[N];
		String[] str= bf.readLine().split(" ");
		for(int i=0;i<N;i++)
			Data[i] = Integer.parseInt(str[i]);
		Solution();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0;i<N;i++) {
			bw.write(Data[i]+" ");
		}
		bw.write("\n");
		bw.flush();
		
	}
	public static void Solution(){
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for(int i=1;i<N;i++) {
			while(!stack.isEmpty()&&Data[stack.peek()]<Data[i]) {
				Data[stack.pop()]= Data[i];
			}
			stack.push(i);
		}
		while(!stack.isEmpty())
			Data[stack.pop()]=-1;
	}
}
