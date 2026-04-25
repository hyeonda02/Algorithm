import java.util.Scanner;
public class Main {

    public static int add(int a, int b){
        return a+b;
    }
    public static int subtract(int a, int b){
        return a-b;
    }
    public static int divide(int a, int b){
        return a/b;
    }
    public static int multiply(int a, int b){
        return a*b;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        char o = sc.next().charAt(0);
        int c = sc.nextInt();
        // Please write your code here.
        int result = 0;
        switch (o){
            case '+':
                result = add(a,c);
                break;
            case '-':
                result = subtract(a,c);
                break;
            case '/':
                result = divide(a,c);
                break;
            case '*':
                result = multiply(a,c);
                break;
            default :
                System.out.println("False");
                return;
        }
        System.out.println(a+" "+o+" "+c+" = "+result);

    }
}