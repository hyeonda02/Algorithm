import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        //한쪽 배열에서는 작은수, 다른쪽 배열에서 큰수 택해서 곱?
        Arrays.sort(B);
        Arrays.sort(A);
        for(int i=0;i<A.length;i++){
            answer+=A[i]*B[B.length-1-i];
            
        }

        return answer;
    }
}