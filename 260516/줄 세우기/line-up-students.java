import java.util.Scanner;
import java.util.Arrays;

class Student {
    int num;
    int height;
    int weight;
    public Student(int num, int height, int weight){
        this.num = num;
        this.height = height;
        this.weight = weight;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Student[] arr = new Student[n];

        for (int i = 0; i < n; i++) {
            int height = scanner.nextInt();
            int weight = scanner.nextInt();
            arr[i] = new Student(i+1,height,weight);
        }
        Arrays.sort(arr,(a,b)->{
            if(a.height!=b.height) return b.height-a.height;
            if(a.weight!=b.weight) return b.weight-a.weight;
            return a.num-b.num;
        });
        
        for (int i = 0; i < n; i++) {
            System.out.printf("%d %d %d\n",arr[i].height,arr[i].weight,arr[i].num);
        }

    }
}