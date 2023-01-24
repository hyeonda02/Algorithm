class Solution {
    public String solution(String s) {
        int max,min;
        String dataArray[] = s.split(" ");
        max=min= Integer.parseInt(dataArray[0]);
        for(int i=1;i<dataArray.length;i++){
            int n = Integer.parseInt(dataArray[i]);
            if(min>n)min=n;
            if(max<n)max=n;
        }
        return min+" "+max;
    }
}