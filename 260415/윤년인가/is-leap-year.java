import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        int Y = scanner.nextInt();
        if(Y%4==0){
            if(Y%100==0&&Y%400!=0){
                System.out.println("false");
            }else{
                System.out.println("true");
            }
        }else{
            System.out.println("false");

        }
    }
}