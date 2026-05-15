import java.util.Scanner;


class Test{
    String type;
    String id;
    int level;
    public Test(){
        type = "user";
        this.id = "codetree";
        this.level = 10;
    }
    public void setTest(String id, int level){
        this.id = id;
        this.level = level;
    }

}


public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        Test test = new Test();
        System.out.println(test.type + " " + test.id + " lv " + test.level);

        String id = scanner.next();
        int level = scanner.nextInt();
        test.setTest(id, level);
        System.out.println(test.type + " " + test.id + " lv " + test.level);

    }
}