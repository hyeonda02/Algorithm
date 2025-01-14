import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : array) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int maxFreq = 0;
        int maxKey = -1;
        boolean duplicate = false;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (value > maxFreq) {
                maxFreq = value;
                maxKey = key;
                duplicate = false;
            } else if (value == maxFreq) {
                duplicate = true;
            }
        }
        return duplicate ? -1 : maxKey;
    }
}