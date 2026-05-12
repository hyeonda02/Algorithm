import java.util.*;

public class Main {
    public static int N;
    public static int K;
    public static String prefix;
    public static void main(String[] args) {
        // Please write your code here.
        Scanner scanner = new Scanner(System.in);
        N = Integer.parseInt(scanner.next());
        K = Integer.parseInt(scanner.next());
        prefix = scanner.next();
        ArrayList<String> arr = new ArrayList<>();

        for(int i=0;i<N;i++){
            String str = scanner.next();
            if(str.startsWith(prefix)){
                arr.add(str);
            }
        }
        Collections.sort(arr);
        System.out.println(arr.get(K-1));

    }
}