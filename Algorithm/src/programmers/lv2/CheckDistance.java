package programmers.lv2;

public class CheckDistance {

    public static void main(String[] args) {

    }

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < answer.length; i++) {
            String[] place = places[i];
            char[][] room = new char[place.length][];

            for (int j = 0; j < room.length; j++) {
                room[j] = place[j].toCharArray();
            }
        }

        // 거리두기 검사 후 answer에 기록

        return answer;
    }
}
