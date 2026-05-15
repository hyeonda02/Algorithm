import java.util.*;

class User{

    String code;
    int num;

    public User(){
        this.code = "A";
        this.num = 0;
    }
    public User(String code, int num){
        this.code = code;
        this.num = num;
    }

}

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        User[] arr = new User[5];
        int minIdx = 0;

        for(int i=0;i<5;i++){
            String code = scanner.next();
            int num = scanner.nextInt();
            arr[i] = new User(code,num);
            if(arr[minIdx].num>arr[i].num) minIdx = i;

        }
        System.out.println(arr[minIdx].code+" "+arr[minIdx].num);

    }
}