import java.io.*;
import java.util.*;

class Solution {
     public int solution(int[] sides) {
        int[] sortedArr = Arrays.stream(sides).sorted().toArray();
        if(sortedArr[0]+sortedArr[1]>sortedArr[2]){
            return 1;
        }else return 2;
    }
}