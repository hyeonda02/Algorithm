// 조건
// 1. String의 길이가 5이고 n의 길이가 3이라면, 3,2개로 잘라야됨
// 2. 딱 맞게 떨어지는 경우 (배열의 길이가 9이고, n=3) 엔 3,3,3으로 나눠서 리턴하면 됨
// 1번의 경우 주의

// 의사코드
// 1. 몇개로 나눠지는지 계산 
// 2. 나누기 및 반환
//   2-1. 마지막의 경우 조심하기 - 끝의 크기를 my_str.length()-1로 해야될듯


import java.util.stream.IntStream;

class Solution {
    public String[] solution(String my_str, int n) {
        // 1. 몇개로 나눠지는지 계산 
        int size = (my_str.length()+n-1)/n;
        // 2. 그 개수만큼 돌면서 자르기(나누기 및 반환)
        return IntStream.range(0,size)
            .mapToObj(i -> my_str.substring(i*n, Math.min((i+1)*n, my_str.length())))
            .toArray(String[]::new);
        
    }
}