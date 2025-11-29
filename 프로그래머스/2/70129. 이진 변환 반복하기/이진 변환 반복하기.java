import java.util.*;

class Solution {
    static int removedCount;
    static int calculatedCount;
    
    public int[] solution(String s) {
        removedCount = 0;
        calculatedCount = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        while (!s.equals("1")) {

            String removed = removeZero(s);
            int num = removed.length();
            calculatedCount++;

            while (num > 0) {
                stack.push(num % 2);
                num = num / 2;
            }

            StringBuilder nextNum = new StringBuilder();
            while (!stack.isEmpty()) {
                nextNum.append(String.valueOf(stack.pop()));
            }

            s = nextNum.toString();
        }
        
        return new int[]{calculatedCount, removedCount};
    }

    private static String removeZero(String s){
        int originLength = s.length();
        String removed = s.replace("0", "");
        removedCount += (originLength - removed.length());
        return removed;
    }
}
