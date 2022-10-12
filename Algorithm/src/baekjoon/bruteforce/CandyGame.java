package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * N x N 크기에 사탕을 채워 놓는다. 사탕의 색은 모두 같지 않을 수도 있다.
 * 상근이는 사탕의 색이 다른 인접한 두 칸을 고른다. 그 다음 고른 칸에 들어있는 사탕을 서로 교환한다.
 * 이제, 모두 같은 색으로 이루어져 있는 가장 긴 연속 부분(행 또는 열)을 고른 다음 그 사탕을 모두 먹는다.
 * 사탕이 채워진 상태가 주어졌을 때, 상근이가 먹을 수 있는 사탕의 최대 개수를 구하는 프로그램을 작성할 것.
 * <p>
 * 보드의 크기 = 3<= N <= 50
 * 다음 N개 줄에는 보드에 채워져 있는 사탕의 색상이 주어진다.
 * 빨간색 C, 파란색 P, 초록색 Z, 노란색 Y
 */
public class CandyGame {
    public static char[][] map2d;
    public static int n;
    public static int max = 0;

    /**
     * 가로로, 세로로 비교하면서 먹을 수 있는 사탕의 최대 갯수 찾기
     */
    public static void candyCheck() {
        // -> 가로 체크
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n-1; j++) {
                // 이전 사탕과 동일한 경우 -> 계속 먹는다
                if (map2d[i][j] == map2d[i][j+1]) {
                    cnt++;
                    // 이전과 다른 사탕인 경우 -> 새로 먹어야하므로 1로 초기화
                } else {
                    cnt = 1;
                }

                // 사탕 최대 개수 저장
                max = Math.max(max, cnt);
            }
        }

        // -> 세로 체크
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n - 1; j++) {
                if (map2d[j][i] == map2d[j + 1][i]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        map2d = new char[n][n];

        // N x N 사탕 입력받기
        for (int i = 0; i < n; i++) {
            String str = bufferedReader.readLine();
            for (int j = 0; j < map2d[i].length; j++) {
                map2d[i][j] = str.charAt(j);
            }
        }

        // 가로로 인접한 두 사탕 교환하고 최대 사탕 개수 찾고 원위치
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                // 가로로 인접한 두 문자 교환
                char tmp = map2d[i][j];
                map2d[i][j] = map2d[i][j + 1];
                map2d[i][j + 1] = tmp;

                // 가로 세로 체크
                candyCheck();

                // 이전에 교환한 문자 복구
                tmp = map2d[i][j];
                map2d[i][j] = map2d[i][j + 1];
                map2d[i][j + 1] = tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                char tmp = map2d[j][i];
                map2d[j][i] = map2d[j + 1][i];
                map2d[j + 1][i] = tmp;

                // 가로, 세로 체크
                candyCheck();

                // 이전에 교환한 문자 복구
                tmp = map2d[j][i];
                map2d[j][i] = map2d[j + 1][i];
                map2d[j + 1][i] = tmp;
            }
        }

        System.out.println(max);
    }
}
