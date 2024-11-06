package chat.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 문제: 섬의 개수 세기
 * 문제 설명
 * 2차원 격자 지도가 주어진다고 해보자.
 * 이 지도는 0과 1로만 이루어져 있으며, 1은 땅을, 0은 물을 나타낸다.
 * 이때 땅으로 연결된 1들을 하나의 "섬"으로 정의한다. 여기서 연결이란 상하좌우로 인접한 1들끼리 연결된 것을 말한다.
 *
 * 지도가 주어졌을 때, 섬의 개수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫 줄에 지도의 세로 크기 n과 가로 크기 m이 주어진다. (1 ≤ n, m ≤ 100)
 * 그다음 n개의 줄에 각각 m개의 값이 공백 없이 주어진다.
 * 출력
 * 섬의 개수를 출력한다.
 * 예제 입력
 * 코드 복사
 * 4 5
 * 11110
 * 11010
 * 11000
 * 00000
 * 예제 출력
 * 코드 복사
 * 1
 * 또 다른 예제 입력과 출력:
 *
 * 코드 복사
 * 4 5
 * 11000
 * 11000
 * 00100
 * 00011
 * 출력:
 *
 * 코드 복사
 * 3
 */
public class 섬의_개수_세기 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int n;
    static int m;
    static int islandCnt;

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    islandCnt++;
                }
            }
        }

        writer.write(islandCnt + "");
        writer.flush();
    }

    private static void dfs(int y, int x) {
        if (visited[y][x]) {
            return;
        }

        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && ny < n && nx >=0 && nx < m && !visited[ny][nx] && map[ny][nx] == 1) {
                dfs(ny, nx);
            }
        }
    }

    private static void init() throws IOException {
        st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로

        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) { // 세로
            String line = reader.readLine();
            for (int j = 0; j < m; j++) { // 가로
                map[i][j] = line.charAt(j) - '0';
            }
        }
    }
}
