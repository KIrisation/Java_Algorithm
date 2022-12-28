package baekjoon.solved.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 1018번: 체스판 다시 칠하기
 */
public class RepaintingChessboard {

    static int N, M;
    static final char[][] BType = {
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
    };

    static final char[][] WType = {
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = reader.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        char[][] inputChessBoard = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = reader.readLine();
            for (int j = 0; j < str.length(); j++) {
                inputChessBoard[i][j] = str.charAt(j);
            }
        }

        int minCnt = Integer.MAX_VALUE;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int BCnt = 0;
                int WCnt = 0;

                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        if (inputChessBoard[k + i][l + j] != BType[k][l]) {
                            ++BCnt;
                        }

                        if (inputChessBoard[k + i][l + j] != WType[k][l]) {
                            ++WCnt;
                        }
                    }
                }

                int x = Math.min(BCnt, WCnt);

                minCnt = Math.min(minCnt, x);
            }
        }

        System.out.println(minCnt);
    }
}
