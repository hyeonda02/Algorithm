import java.util.Arrays;

class Solution {
        public int solution(String[] babbling) {
        String[] arr = {"aya", "ye", "woo", "ma"};
        return (int)Arrays.stream(babbling).filter(i -> {
            for (String target : arr) {
                if (i.contains(target)) {
                    return true;
                }
            }
            return false;
        }).map(i -> {
            for (String target : arr) {
                i = i.replace(target, " ");
            }
            return i;
        }).filter(i -> i.isBlank()).count();

    }
}