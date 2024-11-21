package softeer.lv3.fail;

import java.io.*;
import java.util.*;

/**
 * https://softeer.ai/practice/7721
 */
public class 루돌프_월드컵_Fail {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static double[] powers = new double[4];
    static int[][] scores = new int[5][5];
    static boolean[][] visited = new boolean[5][5];
    static double sum;
    static double currentSum;
    static String[] result = {"win", "lose", "draw"};
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(reader.readLine());


        for (int i = 0; i < 4; i++) {
            powers[i] = Double.parseDouble(st.nextToken());
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                currentSum = 1.0;
                dfs(i, j, result[0]);
            }

            if (isFirstWin()) {
                sum += currentSum;
                continue;
            }


            sum += 0;
        }

        System.out.println(sum);
    }

    public static void dfs(int i, int j, String result) {
        if (j >= 4) {
            return;
        }

        if (i == j) {
            visited[i][j] = true;
            dfs(i, j + 1, result);
        }


        visited[i][j] = true;
        visited[j][i] = true;
        switch (result) {
            case "win":
                scores[i][j] = 3;
                scores[j][i] = 0;
                currentSum *= Double.parseDouble(String.format("%.3f",
                    (4 * powers[i]) / (5 * powers[i] + 5 * powers[j])));
                break;
            case "lose":
                scores[i][j] = 0;
                scores[j][i] = 3;
                currentSum *= Double.parseDouble(String.format("%.3f",
                    (4 * powers[j]) / (5 * powers[j] + 5 * powers[i])));
                break;
            case "draw":
                scores[i][j] = 1;
                scores[j][i] = 1;
                currentSum *= Double.parseDouble(String.format("%.3f",
                    (powers[i] + powers[j]) / ((5 * powers[i]) + (5 * powers[j]))));
                break;
            default:
                break;
        }

//        visited[i][j] = false;
//        visited[j][i] = false;
        dfs(i, j + 1, "win");
        dfs(i, j + 1, "lose");
        dfs(i, j + 1, "draw");

        visited[i][j] = false;
        visited[j][i] = false;
    }

    public static boolean isFirstWin() {
        int[] lineSum = new int[4];
        int firstIdx = -1;
        int firstMax = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                lineSum[i] += scores[i][j];
            }

            if (lineSum[i] > firstMax) {
                firstMax = lineSum[i];
                firstIdx = i;
            }
        }

        int secondIdx = -1;
        int secondMax = 0;
        for (int i = 0; i < 4 && i != firstIdx; i++) {
            if (lineSum[i] > secondMax) {
                secondMax = lineSum[i];
                secondIdx = i;
            }
        }

        return firstIdx == 0 || secondIdx == 0;
    }
}
