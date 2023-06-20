import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //p1541 잃어버린 괄호
    //식이 주어지면, 괄호를 적절하게 넣어서, 값을 최소로 만들기
    //가장 큰 값을 빼야됨 -> 더하는 연산을 모두 실행 후, 빼기 연산을 실행
    static int answer=0;
    public static void main(String[]args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String ex = bf.readLine();
        String[] minusEx = ex.split("-");

        for(int i=0;i<minusEx.length;i++){
            int temp = Sum(minusEx[i]);
            if(i==0) answer+=temp;
            else answer -=temp;
        }
        System.out.println(answer);
    }
    static int Sum(String a){
        int sum=0;
        //오류 이유 -> split("+") 부분에서 컴파일러가 + 부분 인식을 못함
        // 해결책 1. "[+]"로 변경
        // 해결책 2. "\\+"로 변경
        String[] temp = a.split("[+]");
        for(int i=0;i<temp.length;i++){
            sum+=Integer.parseInt(temp[i]);
        }
        return sum;
    }
}
