import java.util.Scanner;

public class Solution {
    public static boolean Solution(int num){
        if(num%2==0){
            return true;
        }else{
            return false;
        }
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(Solution(n)==true){
            System.out.println(n+" is even");
        }else{
            System.out.println(n+" is odd");
        }
    }
}