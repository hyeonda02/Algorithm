// 예시 ) 6,5,3,1,0
// 0 1 3 5 6

// 발표한 논문 n편 중
// h번 이상 인용된 논문이 h편 이상
// 나머지 논문이 h번 이하 인용 되었다면
// h의 최댓값이 H-index

// citations -> 크기가 5, 발표한 논문의 인용 횟수를 담은 배열 citations
// 논문이 총 5개,
//  1번 논문이, 3
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        // 1. 정렬
        Arrays.sort(citations);
        
        // 2.  1번부터 확인 (h인덱스 조건을 만족하는지, 최댓값인지)
        int answer =0;
        int len = citations.length;
        
        for(int i=0;i<len;i++){    
            // 2-1) h 인덱스 조건을 만족하는지
            // h번 이상 인용된 논문이 h편 이상
            // 나머지 논문이 h번 이하 인용 되었다면
            
            int quoted = len-i; // 인용된 논문 수
            int hIdx = quoted;  //h-index인가?
            
            if(citations[i]>=hIdx){
                answer = hIdx;
                break;
            }
        }
        
        return answer;
    }
}