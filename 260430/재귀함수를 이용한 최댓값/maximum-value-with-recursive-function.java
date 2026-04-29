import java.util.Scanner;
public class Main {
    public static int[] arr;
    public static int answer;
    public static void solution(int idx){
        if(idx>=arr.length) return;
        if(arr[idx]>answer) {
            answer=arr[idx];
        }
        solution(++idx);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        answer = arr[0];
        solution(1);
        System.out.println(answer);
    }
}