import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str1 = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		
		int last_value =0;
		for(int i=0;i<n;i++) {
			int value = Integer.parseInt(br.readLine());
			if(value>last_value) {
				for(int j=last_value+1;j<=value;j++) {
					stack.push(j);
					str1.append('+').append("\n");
				}
				last_value=value;
			}else {
				if(stack.peek()!=value) {
					System.out.println("NO");
					return;
				}
			}
			stack.pop();
			str1.append('-').append("\n");
		}
		System.out.println(str1);
	}
}