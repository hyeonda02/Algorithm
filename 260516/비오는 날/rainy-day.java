import java.util.Scanner;

class Day {
    int year;
    int month;
    int th;

    String day;
    String weather;

    public Day(int year, int month, int th, String day, String weather) {
        this.year = year;
        this.month = month;
        this.th = th;
        this.day = day;
        this.weather = weather;
    }
}

public class Main {
    public static boolean isEarlier(Day cur, Day answer){
        if(cur.year!=answer.year){
            return cur.year<answer.year;
        }
        if(cur.month!=answer.month){
            return cur.month<answer.month;
        }
        return cur.th<answer.th;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Day answer = null;

        for (int i = 0; i < n; i++) {
            String date = sc.next();
            String day = sc.next();
            String weather = sc.next();

            String[] dateArr = date.split("-");

            int year = Integer.parseInt(dateArr[0]);
            int month = Integer.parseInt(dateArr[1]);
            int th = Integer.parseInt(dateArr[2]);

            Day cur = new Day(year, month, th, day, weather);

            if(weather.equals("Rain")){
                if(answer==null||isEarlier(cur, answer)) answer = cur;

            }
        }
        System.out.printf("%04d-%02d-%02d %s %s", answer.year, answer.month, answer.th, answer.day, answer.weather);

    }
}