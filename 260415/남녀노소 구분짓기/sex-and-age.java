import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int age = scanner.nextInt();
        if(age>=19){
            if(s==0) {System.out.println("MAN");}
            else {System.out.println("WOMAN");}

        }else {
            if(s==0) {System.out.println("BOY");}
            else {System.out.println("GIRL");}

        }
        
    }
}