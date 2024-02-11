class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            int num = evenNum(food[i]);
            for (int j = 0; j < (num/2); j++) {
                sb.append(i);
            }
        }
        String leftResult = sb.toString();
        StringBuffer sBuffer = new StringBuffer(leftResult);
        String rightResult = sBuffer.reverse().toString();
        return leftResult + 0 + rightResult;
    }

    public int evenNum(int number) {
        if (number % 2 == 0) {
            return number;
        }else {
            return number - 1;
        }
    }

}