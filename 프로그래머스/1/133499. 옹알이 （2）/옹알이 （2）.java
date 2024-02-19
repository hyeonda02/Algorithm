import java.util.Arrays;
class Solution {
    public int solution(String[] babbling) {
         int answer = 0;
        String[] arr = {"aya", "ye", "woo", "ma"};
        return (int)Arrays.stream(babbling).filter(i -> {
            for (String target : arr) {
                if (i.contains(target.repeat(2))) {
                    return false;
                }
            }
            return true;
        }).map(i -> {
            for (String target : arr) {
                i = i.replace(target, " ");
            }
            return i;
        }).filter(i -> i.isBlank()).count();
    }
}