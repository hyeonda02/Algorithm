// 조건 
// 가장 많이 재생된 노래 2개씩 모음 -> 베스트 앨범 출시
// 노래 = 고유 번호 있음
// 1. 노래가 많이 재생된 장르 먼저
// 2. 장르 내에서 많이 재생된 노래 (노래가 여러개라면, 고유번호가 낮은 노래)

// genres : 노래의 장르를 나타내는 문자열 배열
// plays : 노래별 재생 횟수를 나타내는 정수 배열
// 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return


//예시 ["classic", "pop", "classic", "classic", "pop"]
// [500, 600, 150, 800, 2500]
// 1. 장르별로 몇개씩 재생되었는지 계산 classic : 1450, pop : 3100 -> pop
// 2. pop 중 1번 -> 600, 4번 -> 2500 따라서 4,1
// 3. classic 0번 -> 500, 2번 -> 150번, 3번 -> 800번  -> 따라서 3번 0번 (1개는 홀수라 버림)
// 4. 따라서 답은 4,1,3,0
// [4, 1, 3, 0]

// 배열의 크기가 안나와있네..? 그래서 렙3인가
// 그리고 장르가 몋개인지도 모르겠다
// pop class pop class jazz ....
// 300  400  200  100    1
// 0,    1,   2.   3.    4

// 의사 코드 
// 1. 장르별 음악이 총몇번 재생되었는지, 계산 (장르가 뭐가 있는지 모르고, 개수도 모르니 해시맵에 담기), 가장 많이 재생된 장르 알아내기
// 2. 배열을 여러번 돌리면 안될 것 같음 (원래는 배열을 또 돌리면서 해당 장르인 요소들 뽑아내고, 내립차순으로 정렬하는 방식이 단순하긴 한데, 장르의 개수가 몇개인지 몰라서 사용하면 안될 것 같은)
    // HashMap<장르, Music> -> 장르랑, Music(재생횟수, 고유번호)
    // HashMap<장르, Integer> -> 장르별로 얼마나 재생되었는지

import java.util.*;

class Solution {
    static class Music {
        int id;
        int play;
        Music(int id, int play) {
            this.id = id;
            this.play = play;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        List<Integer> result = new ArrayList<>();

 
        HashMap<String, List<Music>> musicInfo = new HashMap<>();
        HashMap<String, Integer> musicPlay = new HashMap<>();

        // 1. 장르별 데이터 수집
        for (int i = 0; i < genres.length; i++) {
            musicInfo.putIfAbsent(genres[i], new ArrayList<>());
            musicInfo.get(genres[i]).add(new Music(i, plays[i]));

            musicPlay.put(genres[i], musicPlay.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 2. 장르별 총 재생수 내림차순 정렬
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(musicPlay.entrySet());
        entries.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // 3. 각 장르에서 인기곡 2개 선택
        for (Map.Entry<String, Integer> entry : entries) {
            String genre = entry.getKey();
            List<Music> musics = musicInfo.get(genre);

            //장르 안에서 곡 정렬 — 재생수 내림차순, 같으면 id 오름차순
            musics.sort((a, b) -> {
                if (b.play == a.play) return a.id - b.id;
                return b.play - a.play;
            });

            for (int i = 0; i < musics.size() && i < 2; i++) {
                result.add(musics.get(i).id);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
