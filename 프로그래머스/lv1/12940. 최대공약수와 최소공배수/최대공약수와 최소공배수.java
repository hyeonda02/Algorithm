class Solution {
    //핵심 알고리즘 : 유클리드 호제법
    public int[] solution(int n, int m) {
        int arr[] = new int[2];
        arr[0] = gcd(n,m); //최대 공약수 -> 유클리드 호제법 이용
        arr[1] = n*m/arr[0];//최소 공배수 -> (a*b/a와b의 최대 공약수) 
        return arr;
        
    }
    private static int gcd(int a, int b){
        if(b==0) return a;
        else return gcd(b,a%b);
    }
}