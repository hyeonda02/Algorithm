class Solution {
    static int num1;
    static int num2;
    static int num3;
    public int solution(int[] nums) {
        int answer =0;
        for (int i = 0; i <= nums.length-3; i++) {
            num1 = nums[i];
            for (int j = i + 1; j <= nums.length-2; j++) {
                num2 = nums[j];
                for (int z = j + 1; z <= nums.length-1; z++) {
                    num3 = nums[z];
                    if(isPrime(num1+num2+num3)) answer++;
                }
            }
        }
        return answer;
    }
    public boolean isPrime(int target){
        for (int i = 2; i <= Math.sqrt(target); i++) {
            if(target%i==0) return false;
        }
        return true;
    }
}