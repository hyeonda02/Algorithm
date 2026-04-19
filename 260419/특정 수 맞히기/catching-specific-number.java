import java.util.*;

public class Main {
    static int num;
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);

        while(true){
            num = scanner.nextInt();
            if(num<25) {
                System.out.println("Higher");
            }else if(num>25){
                System.out.println("Lower");
            }else{
                System.out.println("Good");
                break;
            }
        }
    }
}