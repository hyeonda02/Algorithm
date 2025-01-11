class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for (int i = 0; i < quiz.length;i++) {
            String[] arr = quiz[i].split(" ");
            int num1 = Integer.parseInt(arr[0]);
            String operation = arr[1];
            int num2 = Integer.parseInt(arr[2]);
            int expectedResult = Integer.parseInt(arr[4]);
            int result = arr[1].equals("+") ? num1 + num2 : num1 - num2;
            answer[i] = (result == expectedResult) ? "O" : "X";
        }
        return answer;
    }
}