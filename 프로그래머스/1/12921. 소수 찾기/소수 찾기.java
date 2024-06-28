class Solution {
    public int[] arr;
    private void isPrimeNum(int target){
        arr = new int[target+1];
        for(int i=2;i<=target;i++){
            arr[i] = i;
        }
        for(int i=2;i<=target;i++){
            if(arr[i] ==0) continue;
            for(int j=i+i;j<=target;j+=i){
                arr[j]=0;
            }
        }
    }
    public int solution(int n) {
        isPrimeNum(n);
        int answer =0;
        for(int i=2;i<=n;i++){
            if(arr[i]!=0){
                answer++;
            }
        }
        return answer;
    }
}