// Greedy 적용
// 선택 : 가장 가치가 큰 동전부터 선택한다.
// 검사 : 만약 선택한 동전이 거스름돈부터 크면 그 다음 동전을 선택
// 해답 검사 : 합이 일치하면 문제 해결

// 입력 - 1 ~ 1000 
// 1000 -> 거슬러줌

/**
 * @return void
*/

import java.util.*;

public class Main {
    static int[] coins = {500,100,50,10,5,1};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int remainCoin = 1000-N;
        int answer = 0;
       
        // 1. 선택
        for(int coin : coins){
            // 2. 검사, 해답 검사
            if(remainCoin>=coin) {
                answer += remainCoin/coin;
                remainCoin %= coin;
            }
        }
        
        System.out.print(answer);
        
    }
}