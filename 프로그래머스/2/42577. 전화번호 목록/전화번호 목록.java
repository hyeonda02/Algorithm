// 앞 비교 후, 바로 조건에 만족하면(접두어인 경우) 바로 리턴
// Arrays.sort -> 숫자 정렬일 경우엔 일반적으로 생각하는 오름차순
// -> 문자열 정렬일 경우엔 사전순

// 사전순
// * 왼쪽부터 한 글자씩 비교
// 먼저 다른 글자가 나오면 작은쪽이 먼저
// 한쪽이 끝나면 짧은게 먼저

// 아래 코드를 기준으로 생각해보면
// 사전순 정렬을 할경우, 금방 답을 찾을 가능성이 높아짐
// 19, 198, 1982 이런식으로 비슷한 것끼리 모이기때문


import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i=1;i<phone_book.length;i++){
            if(phone_book[i].startsWith(phone_book[i-1])){
                return false;
            }
        }
        return true; 
        
    }
}