package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StarTake {

}


class MainStarTake {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static String star = "*";
    static String space = " ";
    static String[][] starBoard;

    public static void main(String[] args) {
        int N = nextInt();
        starBoard = new String[N][N];

        recursion(0, 0, N, false);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(starBoard[i][j]);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void recursion(int row, int column, int blockSize, boolean isSpace) {

        if (isSpace) {
            for (int i = row; i < row + blockSize; i++) {
                for (int j = column; j < column + blockSize; j++) {
                    starBoard[i][j] = space;
                }
            }
            return;
        }

        if (blockSize == 1) {
            starBoard[row][column] = star;
            return;
        }

        /*
            N = 27 일 경우 한 블록의 사이즈는 9 이고,
            N = 9 일 경우 한 블록의 사이즈는 3 이다.
            해당 블록의 한 칸을 담을 변수를 의미 size

            count 는 별 출력 누적 합을 의미한다.
         */

        int size = blockSize / 3;
        int count = 0;
        for (int i = row; i < row + blockSize; i += size) {
            for (int j = column; j < column + blockSize; j += size) {
                count++;
                if (count == 5) {
                    recursion(i, j, size, true);
                } else {
                    recursion(i, j, size, false);
                }
            }
        }
    }

    static String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}
