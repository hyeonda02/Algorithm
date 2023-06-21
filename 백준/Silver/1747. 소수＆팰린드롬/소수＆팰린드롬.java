import java.util.Scanner;

public class Main {
    //1747 소수 팰린드롬
    //정수론, 에라토스테네스의 체 이용
    //1.N보다 크거나 같고
    //2.소수이면서 팰린드롬인 수
    //3.가장 작은 수
    //N의 최대 값은 1000000
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[10000001];
        //1. N의 범위까지 소수 구하기
        for(int i=2;i<arr.length;i++){
            arr[i] =i;
        }
        for(int i=2;i<=Math.sqrt(arr.length);i++){
            if(arr[i] ==0) continue;
            for(int j=i*2;j<arr.length;j+=i){
                arr[j]=0;
            }
        }
        int i=N;
        //N부터 1씩 증가시켜주면서 팰린드롬 수인지 판별하기 -> 팰린드롬 판별 함수 따로 작성
        while(true){
            if(arr[i]!=0){
                int result = arr[i];
                if(ifPalindrome(result)){
                    System.out.println(result);
                    break;
                }
            }
            i++;
        }

    }
    //팰린드롬 수 판별
    private static boolean ifPalindrome(int target){
        char arr[] = String.valueOf(target).toCharArray();
        int s=0;
        int e = arr.length-1;
        while(s<e){
            if(arr[s]!=arr[e]) return false;
            s++;
            e--;
        }
        return true;

    }
}
