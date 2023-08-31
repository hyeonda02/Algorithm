import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14425 {
    //백준 14425 문자열 집합
    static int N;
    static int M;
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Node root = new Node();
        while(N>0){
            String text = br.readLine();
            Node now = root;
            for(int i=0;i<text.length();i++){
                char c = text.charAt(i);
                if(now.next[c-'a'] == null)
                    now.next[c-'a'] = new Node();
                now = now.next[c-'a'];
                if(i==text.length()-1)
                    now.isEnd = true;
            }
            N--;
        }
        int count =0;
        while(M>0){
            String txt = br.readLine();
            Node now = root;
            for(int i=0;i<txt.length();i++){
                char c = txt.charAt(i);
                if(now.next[c-'a']==null) break;
                now = now.next[c-'a'];
                if(i == txt.length()-1 && now.isEnd) count++;
            }
            M--;

        }
        System.out.println(count);

    }
    static class Node{
        Node[] next = new Node[26];
        boolean isEnd;
    }

}
