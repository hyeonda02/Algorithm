class Solution {
    public int solution(String binomial) {
        String[] arr = binomial.split(" ");
        int num1 = Integer.parseInt(arr[0]);
        int num2 = Integer.parseInt(arr[2]);
        int answer = 0;
        switch (arr[1]){
            case "+":
                answer = num1 + num2;
                break;
            case "-":
                answer = num1 - num2;
                break;
            case "*":
                answer = num1 * num2;
                break;
        }
        return answer;
    }
}