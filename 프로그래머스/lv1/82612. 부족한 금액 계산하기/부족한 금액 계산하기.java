class Solution {
    public long solution(int price, int money, int count) {
        long payMoney=0;
        for(int i=1;i<=count;i++){
            payMoney+=i*price;
        }
        if(payMoney>money)
            return payMoney-money;
        else return 0;
    }
}