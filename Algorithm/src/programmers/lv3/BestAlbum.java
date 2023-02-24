package programmers.lv3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 장르별로 노래의 총 재생 수를 계산합니다. 이를 위해 HashMap을 이용합니다. 또한, 장르별로 곡의 리스트를 가지는 HashMap을 만듭니다. 총 재생 수가 많은 장르부터 차례로 처리합니다. 각 장르에
 * 대해, 해당 장르의 노래 리스트를 곡의 재생 수에 따라 내림차순으로 정렬합니다. 이때 재생 수가 같으면 고유 번호가 낮은 노래를 우선으로 합니다. 정렬된 노래 리스트에서 노래를 최대 2개까지 선택합니다. 이를
 * 위해 count 변수를 이용합니다. 선택된 노래의 고유 번호를 answerList에 추가합니다. 모든 장르에 대해 위의 과정을 반복합니다
 */

public class BestAlbum {

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreTotalPlays = new HashMap<>();
        Map<String, List<Song>> songMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            if (!genreTotalPlays.containsKey(genre)) {
                genreTotalPlays.put(genre, play);
                songMap.put(genre, new ArrayList<>(List.of(new Song(i, play))));
            } else {
                genreTotalPlays.put(genre, genreTotalPlays.get(genre) + play);
                List<Song> songList = songMap.get(genre);
                songList.add(new Song(i, play));
            }
        }

        List<String> genreSortedList = new ArrayList<>(genreTotalPlays.keySet());
        genreSortedList.sort((g1, g2) -> (genreTotalPlays.get(g2) - genreTotalPlays.get(g1)));

        List<Integer> answerList = new ArrayList<>();
        for (String genre : genreSortedList) {
            List<Song> songList = songMap.get(genre);
            songList.sort((s1, s2) -> {
                if (s1.play == s2.play) {
                    return s1.id - s2.id;
                }
                return s2.play - s1.play;
            });

            int count = 0;
            for (Song song : songList) {
                answerList.add(song.id);
                count++;
                if (count == 2) {
                    break;
                }
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    static class Song {

        int id;
        int play;

        public Song(int id, int play) {
            this.id = id;
            this.play = play;
        }
    }
}