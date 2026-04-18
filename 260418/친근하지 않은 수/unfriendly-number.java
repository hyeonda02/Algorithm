import java.util.*;

public class Main {
    static int N;
    static int answer;

    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        
        N = scanner.nextInt();
        answer = 0;


        for(int i=1;i<=N;i++){
            if(i%2==0||i%3==0||i%5==0){
                continue;
            }
            answer++;

        }
        System.out.println(answer);


    }
}