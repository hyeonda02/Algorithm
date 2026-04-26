import java.util.Scanner;

class IntWrapper {
    int value;
    public IntWrapper(int value){
        this.value = value;
    }
}
public class Main {
    public static void solution(IntWrapper a, IntWrapper b){
        if(a.value>b.value){
            a.value += 25;
            b.value *= 2;
        } else {
            b.value += 25;
            a.value *= 2;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        // Please write your code here.
        IntWrapper classA = new IntWrapper(a);
        IntWrapper classB = new IntWrapper(b);

        solution(classA, classB);
        System.out.println(classA.value + " " + classB.value);

    }
}