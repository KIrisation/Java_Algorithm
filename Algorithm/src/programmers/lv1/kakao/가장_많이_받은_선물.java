package programmers.lv1.kakao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/258712
 *
 * 해당 코드 실패점
 *
 * 선물 지수를 표로 나타내는 대는 성공.
 * 그러나 주고 받은 선물을 나타내는 그래프를 만드는데는 실패.
 *
 * 주고 받은 선물을 나타낼 수 있는 그래프의 구현이 필요
 */
public class 가장_많이_받은_선물 {

    public static void main(String[] args) {

    }

    public int solution(String[] friends, String[] gifts) {
        int answer = 0;

        Map<String, Integer> dic = new HashMap<>();

        for (int i = 0; i < friends.length; i++) {
            dic.put(friends[i], i);
        }

        int[][] giftGraph = new int[friends.length][friends.length];
        for (String gift : gifts) {
            String[] giftName = gift.split(" ");
            giftGraph[dic.get(giftName[0])][dic.get(giftName[1])]++;
        }

        int[][] giftScore = new int[friends.length][3];
        for (int i = 0; i < friends.length; i++) {
            int givePoint = 0;
            int receivePoint = 0;

            for (int j = 0; j < gifts.length; j++) {
                String[] splited = gifts[j].split(" ");

                String givePeople = splited[0];
                String receivePeople = splited[1];

                if (friends[i].equals(givePeople)) {
                    giftScore[i][0] = ++givePoint;
                }

                if (friends[i].equals(receivePeople)) {
                    giftScore[i][1] = ++receivePoint;
                }
            }
            giftScore[i][2] = givePoint - receivePoint;
        }

        System.out.println(Arrays.deepToString(giftScore));

        for (int i = 0; i < friends.length; i++) {
            int num = 0;

            for (int j = 0; j < friends.length; j++) {
                if (i == j) {
                    continue;
                }

                if (giftGraph[i][j] > giftGraph[j][i]
                    || giftGraph[i][j] == giftGraph[j][i] && giftScore[i][2] > giftScore[j][2]) {
                    num++;
                }
            }

            if (answer < num) {
                answer = num;
            }
        }

        return answer;
    }
}
