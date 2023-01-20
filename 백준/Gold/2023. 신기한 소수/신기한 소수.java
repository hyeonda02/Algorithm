import java.util.Scanner;

public class Main {
    //신기한 소수
    static int N;
    static boolean isPrime(int num){
        for(int i=2;i<num/2;i++){
            if(num%i==0)
                return false;
        }
        return true;
    }
    static void DFS(int num,int jarisu) {
        //현재 자릿수와 N값이 같다면, 그냥 소수인지 확인만 하고 출력하면 됨
        if(jarisu==N){
            if(isPrime(num))
                System.out.println(num);
        }
        for(int i=1;i<10;i++){
            //i==2이라면(짝수이라면) 소수가 될 수 없다.
            if(i%2==0)
                continue;
            //자리수 하나 증가 후 거기서 판별 시작
            if(isPrime(num*10+i)){
                DFS(num*10+i,jarisu+1);

            }
        }
    }
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        //일의 자리 소수는 2,3,5,7 밖에 없으므로 4가지 경우에 대해서만 DFS 함수 호출
        DFS(2,1);
        DFS(3,1);
        DFS(5,1);
        DFS(7,1);
    }
}
