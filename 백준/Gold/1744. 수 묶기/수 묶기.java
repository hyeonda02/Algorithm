import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    //수를 묶어서 최댓값으로 만들기
    //수의 범위는 -10000 ~10000
    //수의 범위가 10000이므로 시간 복잡도는 생각 안해도 될 것 같다.
    //음수, 양수, 1,0 으로 나눠서 저장 ( 총 4개의 그룹으로 나눠서 저장 )
    //그리디, 우선순위 큐
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int sum=0;

        PriorityQueue<Integer> positiveNum = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negativeNum = new PriorityQueue<>();
        int oneCount = 0;
        int zeroCount =0;

        //N개의 수가 들어오므로, for 루프 돌면서 4개의 그룹에 따라 수를 나누기
        for(int i=0;i<N;i++){
            int data = scanner.nextInt();
            if(data>1) positiveNum.add(data);
            else if(data == 1) oneCount++;
            else if(data == 0) zeroCount++;
            else negativeNum.add(data);
        }
        //1. 양수 처리하기 (2개 꺼내서 곱, 1개 남는다면 더하기 )
         while(positiveNum.size()>1){
             int firstNum = positiveNum.remove();
             int secondNum = positiveNum.remove();
             sum+=(firstNum*secondNum);
         }
         if(!positiveNum.isEmpty()) sum+=positiveNum.remove();
        //2. 음수 처리하기 ( 2개 꺼내서 곱 )
        while(negativeNum.size()>1){
            int firstNum = negativeNum.remove();
            int secondNum = negativeNum.remove();
            sum+=(firstNum*secondNum);
        }
        //3. 0 처리하기 ( if negativeNum is not Empty, 0과 곱)
        if(!negativeNum.isEmpty()){
            if(zeroCount == 0) sum+=negativeNum.remove();
        }
        //4. 1 처리하기 ( add )
        sum+=oneCount;
        System.out.println(sum);
    }
}
