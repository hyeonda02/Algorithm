class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String preStr = my_string.substring(0,s);
        int last = s+overwrite_string.length();
        String lastStr = my_string.substring(last);
        
        return preStr+overwrite_string+lastStr;
    }
}