import java.util.*;
public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		scanner.close();
		Solution();
		
	}
	public static void Solution() {
		Queue<Integer> MyQueue = new LinkedList<>();
		for(int i=1;i<=N;i++)
			MyQueue.add(i);
		while(MyQueue.size()>1) {
			MyQueue.poll();
			MyQueue.add(MyQueue.poll());
		}
		System.out.println(MyQueue.poll());
	}
}
