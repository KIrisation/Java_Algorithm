package softeer.lv3.success;

import java.io.*;
import java.util.*;

public class 루돌프_월드컵_Success {

    static double[] powers = new double[4]; // 루돌프의 힘
    static double totalProbability = 0;    // 모든 경우의 수에서 확률 합산
    static double successfulProbability = 0; // 1번 루돌프가 상위 2등일 확률 합산

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        for (int i = 0; i < 4; i++) {
            powers[i] = Double.parseDouble(st.nextToken());
        }

        int[][] matches = {
            {0, 1}, {0, 2}, {0, 3},
            {1, 2}, {1, 3}, {2, 3}
        };

        simulate(0, matches, new int[4], 1.0);

        double result = (successfulProbability / totalProbability) * 100;
        System.out.printf("%.3f\n", result);
    }

    // 시뮬레이션 함수
    public static void simulate(int matchIdx, int[][] matches, int[] scores, double probability) {
        if (matchIdx == matches.length) {
            totalProbability += probability;
            if (isTopTwo(scores)) {
                successfulProbability += probability;
            }
            return;
        }

        int a = matches[matchIdx][0];
        int b = matches[matchIdx][1];

        // 승리, 패배, 무승부 확률 계산
        double winProb = (4 * powers[a]) / (5 * powers[a] + 5 * powers[b]);
        double loseProb = (4 * powers[b]) / (5 * powers[a] + 5 * powers[b]);
        double drawProb = (powers[a] + powers[b]) / (5 * powers[a] + 5 * powers[b]);

        // 승리
        scores[a] += 3;
        simulate(matchIdx + 1, matches, scores, probability * winProb);
        scores[a] -= 3;

        // 패배
        scores[b] += 3;
        simulate(matchIdx + 1, matches, scores, probability * loseProb);
        scores[b] -= 3;

        // 무승부
        scores[a] += 1;
        scores[b] += 1;
        simulate(matchIdx + 1, matches, scores, probability * drawProb);
        scores[a] -= 1;
        scores[b] -= 1;
    }

    // 1번 루돌프가 상위 2등인지 확인
    public static boolean isTopTwo(int[] scores) {
        int[] sortedScores = scores.clone();
        Arrays.sort(sortedScores);

        // 상위 2등 점수를 확인
        int secondHighest = sortedScores[2]; // 두 번째 높은 점수
        int firstHighest = sortedScores[3]; // 가장 높은 점수

        // 1번 루돌프가 상위 2등에 포함되는지 확인
        return scores[0] >= secondHighest || scores[0] == firstHighest;
    }
}