class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int multi = 1;
        int sum = 0;
        for(int num : num_list){
            multi *= num;
            sum += num;
        }
        return (multi<Math.pow(sum,2)) ? 1 : 0;
    }
}