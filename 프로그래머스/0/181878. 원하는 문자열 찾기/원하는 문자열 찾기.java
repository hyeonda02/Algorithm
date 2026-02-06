class Solution {
    public int solution(String myString, String pat) {
        String myStringLow = myString.toLowerCase();
        String patLow = pat.toLowerCase();
        
        return myStringLow.contains(patLow) ? 1 : 0;
    }
}