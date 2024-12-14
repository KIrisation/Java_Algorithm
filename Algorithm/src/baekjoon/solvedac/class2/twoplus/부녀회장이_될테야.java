package baekjoon.solvedac.class2.twoplus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부녀회장이_될테야 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine()); // 테스트 갯수

        int[][] apart = new int[15][15];
        for (int i = 0; i < 15; i++) {
            apart[0][i] = i;
            apart[i][1] = 1;
        }

        for (int i = 1; i < apart.length; i++) {
            for (int j = 2; j < apart[0].length; j++) {
                for (int k = j; k > 0; k--) {
                    apart[i][j] += apart[i - 1][k];
                }
            }
        }
        
        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(reader.readLine()); // k층
            int n = Integer.parseInt(reader.readLine()); // n호

            System.out.println(apart[k][n]);
        }
    }
}
