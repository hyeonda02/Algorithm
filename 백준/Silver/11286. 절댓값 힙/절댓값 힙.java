import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args)throws IOException {
		N = Integer.parseInt(bf.readLine());
		Solution();
	}
	public static void Solution()throws IOException{
		PriorityQueue<Integer> MyQueue = new PriorityQueue<>((o1,o2)->{
			int first = Math.abs(o1);
			int second = Math.abs(o2);
			if(first==second) {
				return o1>o2?1:-1; 
			}
			else 
				return first-second;
		});
		for(int i=0;i<N;i++) {
			int quest = Integer.parseInt(bf.readLine());
			if(quest == 0) {
				if(MyQueue.isEmpty())
					System.out.println("0");
				else
					System.out.println(MyQueue.poll());
			}
			else
				MyQueue.add(quest);
		}
	}
}
