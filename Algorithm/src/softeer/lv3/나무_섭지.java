package softeer.lv3;

import java.io.*;
import java.util.*;

public class 나무_섭지 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static String[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int humanDistance;
    static int ghostDistance;

    static class Player {
        private int y;
        private int x;
        private boolean isGhost;

        public Player(int y, int x, boolean isGhost) {
            this.y = y;
            this.x = x;
            this.isGhost = isGhost;
        }

        public int getY() {
            return this.y;
        }

        public int getX() {
            return this.x;
        }

        public boolean isGhost() {
            return this.isGhost;
        }
    }

    static List<Player> players = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new String[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(reader.readLine());
            for(int j = 1; j <= M; j++) {
                map[i][j] = st.nextToken();

                if (map[i][j].equals("N")) {
                    players.add(new Player(i, j, false));
                } else if(map[i][j].equals("G")) {
                    players.add(new Player(i, j, true));
                }
            }
        }

        for (Player player : players) {
            findMinDistance(player, player.getY(), player.getX(), map, 0, 0);
        }


        if (humanDistance > ghostDistance) {
            writer.write("Yes");
        } else {
            writer.write("No");
        }

        writer.flush();
    }

    public static void findMinDistance(Player player, int y, int x, String[][] map, int distance, int dir) {
        if (dir == 4 && !player.isGhost()) {
            ghostDistance = Integer.MAX_VALUE;
            return;
        }

        if (map[y][x].equals("G")  && !player.isGhost()) {
            humanDistance = distance;
            return;
        } else if(map[y][x].equals("G") && player.isGhost()) {
            ghostDistance = distance;
            return;
        }

        if (!player.isGhost()) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if (ny >= 1 && ny <= map.length - 1 && nx >= 1 && nx <= map.length - 1 && !map[ny][nx].equals("#") && !map[ny][nx].equals("G")) {
                findMinDistance(player, ny, nx, map, distance + 1, dir + 1);
            }
        } else {
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if (ny >= 1 && ny <= map.length - 1 && nx >= 1 && nx <= map.length - 1) {
                findMinDistance(player, ny, nx, map, distance + 1, dir + 1);
            }
        }
    }
}

