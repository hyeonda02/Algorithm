
class Solution {
    public int[] solution(int[] arr) {
        int min = arr[0];
        int index =0;
        if(arr.length==1){
            arr[0] = -1;
            return arr;
        }
        for(int i=0;i<arr.length;i++){
            if(min>=arr[i]){
                min=arr[i];
                index =i;
            }
        }
        int count=0;
        int[] resultArr = new int[arr.length-1];
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=min){
                resultArr[count]=arr[i];
                count++;
            }
        }
        
        return resultArr;
        
    }
}