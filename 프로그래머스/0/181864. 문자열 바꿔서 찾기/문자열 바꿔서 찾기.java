class Solution {
    public int solution(String myString, String pat) {
        return myString.replace('A', 'X')
                   .replace('B', 'A')
                   .replace('X', 'B').contains(pat) ? 1 : 0;
    }
}