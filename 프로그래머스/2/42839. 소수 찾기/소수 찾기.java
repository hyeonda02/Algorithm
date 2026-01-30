// numbers 는 길이 1~7 문자열
// 전부 하나하나 확인 (소수 판별)

// 1. dfs로 모둔 경우의 수를 만든다.
// 2. 경우의 수들을 하나하나 소수인지 판별한다.
import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    boolean[] visited;
    char[] numArr;
    
    public int solution(String numbers) {
        int answer = 0;
        numArr = numbers.toCharArray();
        visited = new boolean[numArr.length];
        
        // dfs 호출, 경우의 수 생성
        dfs("");
        
        // 경우의 수가 소수인지 판별
        for(int num : set){
            if(isPrime(num)) answer++;
        }
        
        return answer;
    }
    
    public void dfs(String numStr){
        if(!numStr.isEmpty()){
            set.add(Integer.parseInt(numStr));
        }
        for(int i=0;i<numArr.length;i++){
            if(!visited[i]){
                visited[i] = true; // 1. 방문 처리
                dfs(numStr + numArr[i]);// 2. dfs (다음 차례로 이동)
                visited[i] = false; // 3. 다시 되돌리기
            }
        }
        
    }
    
    public boolean isPrime(int num){
        if(num<2) return false;
        for(int i=2;i*i<=num;i++){
            if(num%i==0) return false;
        }
        return true;
        
    }
}