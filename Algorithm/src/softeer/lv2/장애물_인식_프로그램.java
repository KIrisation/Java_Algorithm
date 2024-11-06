package softeer.lv2;

import java.io.*;
import java.util.*;

public class 장애물_인식_프로그램 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static boolean[][] visted;
    static int[][] map;
    static int currentCnt;
    static List<Integer> answer = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < N; i++) {
            currentCnt = 0;
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    dfs(i, j);
                    answer.add(currentCnt);
                }
            }
        }

        print();
    }

    private static void print() throws IOException {
        if (answer.isEmpty()) {
            writer.write("0");
            writer.flush();
            return;
        }

        writer.write(answer.size() + "\n");

        for (Integer answerCnt : answer) {
            writer.write(String.valueOf(answerCnt));
        }

        writer.flush();
    }

    private static void init() throws IOException {
        st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());

        visted = new boolean[N][N];
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = reader.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
    }

    private static void dfs(int y, int x) {
        visted[y][x] = true;
        currentCnt++;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && ny < N && nx >= 0 && nx < N && !visted[ny][nx] && map[ny][nx] == 1) {
                dfs(ny, nx);
            }
        }
    }

}
