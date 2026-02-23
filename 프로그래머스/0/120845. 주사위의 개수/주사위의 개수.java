class Solution {
    public int solution(int[] box, int n) {
        int col = box[0]/n;
        int row = box[1]/n;
        int height = box[2]/n;
        return col*row*height;
    }
}