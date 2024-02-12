class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int cards1Index=0, cards2Index =0;
        for (String goalWord: goal) {
            if (cards1Index<cards1.length && cards1[cards1Index].equals(goalWord) ) {
                cards1Index++;
                continue;
            }else if(cards2Index<cards2.length && cards2[cards2Index].equals(goalWord)){
                cards2Index++;
                continue;
            }else{
                return "No";
            }
        }
        return "Yes";
    }
}