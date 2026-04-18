import java.util.*;

public class Main {
    static int num;
    static int answer1;
    static int answer2;
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        num = 0;
        answer1 = 0;
        answer2 = 0;

        for(int i=0;i<10;i++){
            num = scanner.nextInt();
            if(num%3==0) answer1++;
            if(num%5==0) answer2++;

        }
        System.out.println(answer1+ " "+answer2);

    }
}