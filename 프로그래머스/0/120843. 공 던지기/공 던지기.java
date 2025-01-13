class Solution {
    public int solution(int[] numbers, int k) {
        int position =0;
        for (int i = 0; i < k - 1; i++) {
            position = (position + 2 > numbers.length - 1) ? (position + 2) - numbers.length : position + 2;
        }
        return numbers[position];
    }
}