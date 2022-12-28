package programmers.lv2;

import java.util.Arrays;

public class Fatigue {

    static int maxAnswer = 0;
    static boolean[] visit;

    public static void main(String[] args) {
        System.out.println(solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
    }

    public static int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        Arrays.fill(visit, false);

        calculateFatigue(k, dungeons, 0, 0);

        return maxAnswer;
    }
    private static void calculateFatigue(int k, int[][] dungeons, int cnt, int answer) {
        if (cnt == dungeons.length) {
            maxAnswer = Math.max(maxAnswer, answer);
            return;
        }

        for (int i = 0; i < dungeons.length; i++) {
            if (!visit[i]) {
                visit[i] = true;

                if (dungeons[i][0] <= k) {
                    calculateFatigue( k - dungeons[i][1], dungeons, cnt + 1, answer + 1);
                } else {
                    calculateFatigue(k, dungeons, cnt + 1, answer);
                }

                visit[i] = false;
            }
        }
    }
}
