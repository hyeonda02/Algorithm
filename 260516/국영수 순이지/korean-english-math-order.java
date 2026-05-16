import java.util.Scanner;
import java.util.Arrays;

class Student {
    String name;
    int korean;
    int english;
    int math;
    public Student(String name, int korean, int english, int math){
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;

    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] arr = new Student[n];

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int korean = sc.nextInt();
            int english = sc.nextInt();
            int math = sc.nextInt();
            arr[i] = new Student(name, korean, english, math);
        }
        Arrays.sort(arr,(a,b)->{
            if(a.korean!=b.korean) return b.korean-a.korean;
            if(a.english!=b.english) return b.english-a.english;
            return b.math-a.math;
        });
        for (int i = 0; i < n; i++) {
            Student cur = arr[i];
            System.out.printf("%s %d %d %d\n",cur.name, cur.korean, cur.english, cur.math);

        }

    }
}