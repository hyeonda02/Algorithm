import java.util.PriorityQueue;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
	
		PriorityQueue<Integer> priorityqueue = new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			int X = Integer.parseInt(st.nextToken());
			if(X==0) {
				if(priorityqueue.peek()==null) System.out.println(0);
				else System.out.println(priorityqueue.poll());
			}
			else if(X>=1) priorityqueue.offer(X);
		}
		bf.close();
	}
}
