// 피자는 6조각 -> 한판
// n과 6의 최소 공배수
import java.util.*;

class Solution {
    private int getGCD(int a, int b){
        if(b==0) return a;
        return getGCD(b, a%b);
        
    }
    private int getLCM(int a, int b){
        return a*b/getGCD(a,b);
    }
    public int solution(int n) {
        int piece = getLCM(Math.max(6,n),Math.min(6,n));
        return piece/6;
    }
}