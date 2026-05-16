import java.util.Arrays;
import java.util.Scanner;

class Student implements Comparable<Student>{
    String name;
    int korean;
    int english;
    int math;
    public Student(String name, int korean,  int english, int math){
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    @Override
    public int compareTo(Student student){
        return (this.korean+this.english+this.math)-(student.korean+student.english+student.math);

    }
}

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Student[] arr = new Student[n];

        for(int i=0;i<n;i++){
            String name = scanner.next();
            int korean = scanner.nextInt();
            int english = scanner.nextInt();
            int math = scanner.nextInt();
            arr[i] = new Student(name, korean, english, math);

        }
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            System.out.printf("%s %d %d %d\n", arr[i].name, arr[i].korean, arr[i].english, arr[i].math);

        }
    }
}