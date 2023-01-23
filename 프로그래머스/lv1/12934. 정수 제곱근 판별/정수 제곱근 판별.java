import java.util.*;
class Solution {
    public long solution(long n) {
        Double value = Math.sqrt(n);
        if(value==value.intValue())
            return (long)Math.pow(value+1,2);
        else return -1;
    }
}