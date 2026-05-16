import java.util.Scanner;
import java.util.Arrays;

class People{
    String name;
    int height;
    int weight;
    public People(String name, int height, int weight){
        this.name = name;
        this.height = height;
        this.weight = weight;
    }
}

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        People[] arr = new People[n];

        for(int i=0;i<n;i++){
            String name = scanner.next();
            int height = scanner.nextInt();
            int weight = scanner.nextInt();
            arr[i] = new People(name, height, weight);

        }

        Arrays.sort(arr,(a,b)->a.height-b.height);
        for(int i=0;i<n;i++){
            People cur = arr[i];
            System.out.printf("%s %d %d\n", cur.name, cur.height, cur.weight);

        }

    }
}