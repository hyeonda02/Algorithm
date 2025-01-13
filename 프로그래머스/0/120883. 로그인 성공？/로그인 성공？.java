import java.util.Arrays;


class Solution {
    public String solution(String[] id_pw, String[][] db) {
        return Arrays.stream(db).filter(user-> user[0].equals(id_pw[0]))
            .findFirst()
            .map(user -> user[1].equals(id_pw[1]) ? "login" : "wrong pw")
            .orElse("fail");
    }
}