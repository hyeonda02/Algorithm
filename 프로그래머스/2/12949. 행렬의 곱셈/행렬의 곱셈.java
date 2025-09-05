class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 1. 2차원 행렬 초기화
        int[][] answer = new int[arr1.length][arr2[0].length];
        // 2. 순회하면서 곱셈 계산
        for(int i=0;i<arr1.length;i++){
            for(int j =0;j<arr2[0].length;j++){
                for(int k=0;k<arr1[0].length;k++){
        // 3. 곱셈 후 배열에 넣기
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}