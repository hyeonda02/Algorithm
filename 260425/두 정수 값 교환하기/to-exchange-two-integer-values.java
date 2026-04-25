import java.util.*;

class IntWrapper {
    int value;
    public IntWrapper(int value){
        this.value=value;
    }
}

public class Main {
    public static void swap(IntWrapper n,IntWrapper m){
        int temp = m.value;
        m.value = n.value;
        n.value = temp;

    }

    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        IntWrapper intN = new IntWrapper(n);
        IntWrapper intM = new IntWrapper(m);  

        swap(intN, intM);
        System.out.println(intN.value+" "+intM.value);      

    }
}