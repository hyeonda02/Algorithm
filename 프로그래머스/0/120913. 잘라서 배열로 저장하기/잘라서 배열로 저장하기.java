class Solution {
    public String[] solution(String my_str, int n) {
        int size = (my_str.length() + n - 1) / n; 
        String[] answer = new String[size]; 

        int start = 0; 
        for (int i = 0; i < size; i++) {
            int end = Math.min(start + n, my_str.length()); 
            answer[i] = my_str.substring(start, end); 
            start += n; 
        }

        return answer;
    }
}