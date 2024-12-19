package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제의 단순화가 필요했던게 배추 뭉치가 몇개인지 찾아내면 끝나는 문제임.
 */
public class 유기농_배추 {

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        for (int i = 0; i < N; i++) {
            String[] s = reader.readLine().split(" ");
            int fullX = Integer.parseInt(s[0]);
            int fullY = Integer.parseInt(s[1]);
            int bNum = Integer.parseInt(s[2]);
            int[][] maps = new int[fullY][fullX];

            for (int j = 0; j < bNum; j++) {
                String[] s1 = reader.readLine().split(" ");
                int x = Integer.parseInt(s1[0]);
                int y = Integer.parseInt(s1[1]);

                maps[y][x] = 1;
            }

            cnt = 0;
            for (int j = 0; j < fullY; j++) {
                for (int k = 0; k < fullX; k++) {
                    if (maps[j][k] == 1) {
                        dfs(maps, j, k);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }

    }

    public static void dfs(int[][] maps, int y, int x) {
        maps[y][x] = 0; // 벌레가 먹은 거임

        for (int i = 0; i < 4; i++) {
            int my = y + dy[i];
            int mx = x + dx[i];

            if (my >= 0 && my < maps.length && mx >= 0 && mx < maps[0].length && (maps[my][mx] == 1)) {
                dfs(maps, my, mx);
            }
        }
    }
}
