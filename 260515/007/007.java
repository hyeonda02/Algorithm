import java.util.Scanner;

public class Main {
    public static class Test{
        String code;
        String point;
        int time;
        public Test(String code, String point, int time){
            this.code = code;
            this.point = point;
            this.time = time;

        }
    }
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        String code = scanner.next();
        String point = scanner.next();
        int time = scanner.nextInt();

        Test test = new Test(code,point,time);
        System.out.println("secret code : "+test.code);
        System.out.println("meeting point : "+test.point);
        System.out.println("time : "+ test.time);

    }
}