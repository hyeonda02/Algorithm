import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] strlist) {
        return Arrays.stream(strlist)
                .map(String::length)
                .collect(Collectors.toList()).stream().mapToInt(Integer::intValue).toArray();
    }
}