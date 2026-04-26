import java.util.Scanner;
import java.util.HashMap;

public class Main {
    static HashMap<Character,Integer> map;

    public static boolean solution(String a, HashMap<Character,Integer> map){
        for(int i=0; i<a.length();i++){   
            char c = a.charAt(i);   
            if(map.containsKey(c)) {
                map.put(c,map.get(c)+1);
            } else {
                map.put(c,1);
            }

        }
        if(map.size()>=2) return true;
        return false;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        // Please write your code here.
        map = new HashMap<>();
        if(solution(A, map)) {
            System.out.println("Yes");
            return;
        }
        System.out.println("No");


    }
}