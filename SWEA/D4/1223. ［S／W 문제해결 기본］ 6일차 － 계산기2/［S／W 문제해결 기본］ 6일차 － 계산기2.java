import java.util.*;

class Solution
{
    static int priority(char op) {
    	if(op=='*') return 2;
        if(op=='+') return 1;
        return 0;
    }
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int len = sc.nextInt();
            String infix = sc.next();
            
            Stack<Character> opStack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            
            for(int i=0;i<len;i++){
            	char c = infix.charAt(i);
                
                if(Character.isDigit(c)){
                	sb.append(c);
                } else{
                	while(!opStack.isEmpty()&& priority(opStack.peek())>priority(c)) {
                        sb.append(opStack.pop());
                    	
                    }
                    opStack.push(c);
                }
            }
            while(!opStack.isEmpty()) {
            	sb.append(opStack.pop());
            }
            // 후위 계산
            Stack<Integer> numStack = new Stack<>();
            for(int i=0;i<sb.length();i++){
            	char c = sb.charAt(i);
                if(Character.isDigit(c)){
                	numStack.push(c-'0');
                }else{
                	int b = numStack.pop();
                    int a = numStack.pop();
                    
                    if(c=='+') numStack.push(a+b);
                    else if (c=='*') numStack.push(a*b);
                }
            }
            int answer = numStack.pop();
			System.out.println("#"+test_case+" "+answer);
		}
	}
}