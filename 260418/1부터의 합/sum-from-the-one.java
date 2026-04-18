import java.util.*;

public class Main {
    static int N;
    static int answer;
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        answer = 0;

        for(int i=1;i<=100;i++){
            answer +=i;
            if(answer>=N){
                System.out.println(i);
                break;
            }
        }
    }
}