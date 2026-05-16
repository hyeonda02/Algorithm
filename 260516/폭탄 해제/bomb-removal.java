import java.util.*;

class Boom {
    String code;
    char color;
    int second;
    public Boom(String code, char color, int second){
        this.code = code;
        this.color = color;
        this.second = second;
    }
}

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        String code = scanner.next();
        char c = scanner.next().charAt(0);
        int second = scanner.nextInt();

        Boom boom = new Boom(code,c,second);
        System.out.println("code : "+boom.code);
        System.out.println("color : "+boom.color);
        System.out.println("second : "+boom.second);


    }
}