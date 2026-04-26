import java.util.Scanner;
public class Main {
    static int findIdx(String text, String pattern){
        for(int i=0;i<text.length()-pattern.length()+1;i++){
            String str = text.substring(i,pattern.length()+i);
            if(str.equals(pattern)) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        String pattern = sc.next();
        // Please write your code here.
        System.out.println(findIdx(text,pattern));

        

    }
}