import java.util.*;
import java.io.*;

class Student{
    String name;
    int height;
    double weight;
    public Student(String name, int height, double weight){
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

}

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Student[] arr = new Student[5];
        for(int i=0;i<5;i++){
            st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();
            int height = Integer.parseInt(st.nextToken());
            double weight = Double.parseDouble(st.nextToken());

            arr[i] = new Student(name, height, weight);
        }

        Arrays.sort(arr,(a,b)-> a.name.compareTo(b.name));
        System.out.println("name");
        for(int i=0;i<5;i++){
            System.out.printf("%s %d %.1f\n", arr[i].name, arr[i].height, arr[i].weight);
        }

        Arrays.sort(arr,(a,b)-> b.height-a.height);
        System.out.println("\nheight");
        for(int i=0;i<5;i++){
            System.out.printf("%s %d %.1f\n", arr[i].name, arr[i].height, arr[i].weight);
        }


    }
}