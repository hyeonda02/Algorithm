import java.util.*;

class People{
    String name;
    String add;
    String loc;

    public People(String name, String add, String loc){
        this.name = name;
        this.add = add;
        this.loc = loc;
    }
}

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        People[] arr = new People[N];
        int idx = 0;

        for(int i=0;i<N;i++){
            String name = scanner.next();
            String add = scanner.next();
            String loc = scanner.next();
            arr[i] = new People(name, add, loc);

            if(arr[i].name.compareTo(arr[idx].name)>0)idx = i;

        }
        System.out.println("name "+ arr[idx].name);
        System.out.println("addr "+ arr[idx].add);
        System.out.println("city "+ arr[idx].loc);
    }
}