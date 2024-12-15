package baekjoon.solvedac.class2.twoplus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class solveddotac {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());

        int[] scores = new int[N + 1]; // 11 1 ~ 10 10 9 8
        for (int i = 1; i <= N; i++) {
            scores[i] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(scores); // 점수 별로 정렬됨.

        int sum = 0;
        double excludedPeopleCnt = Math.round(N * 0.15);
        for (int i = (int) excludedPeopleCnt + 1; i < scores.length - excludedPeopleCnt; i++) {
            sum += scores[i];
        }

        double excludedPeopleNCnt = N - (2 * excludedPeopleCnt);
        System.out.println(Math.round(sum / excludedPeopleNCnt));
    }
}
