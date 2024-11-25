package programmers.lv2.fail;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 리코쳇_로봇_Fail {

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static List<Integer> answers = new ArrayList<>();

    public int solution(String[] board) {
        int answer = 0;
        String[][] map = new String[board.length][board[0].length()];
        boolean[][] visited = new boolean[board.length][board[0].length()];

        int startY = -1;
        int startX = -1;
        int endY = -1;
        int endX = -1;
        for (int i = 0; i < board.length; i++) {
            String[] splited = board[i].split("");

            for (int j = 0; j < splited.length; j++) {
                if (splited[j].equals("R")) {
                    startY = i;
                    startX = j;
                }

                if (splited[j].equals("G")) {
                    endY = i;
                    endX = j;
                }

                map[i][j] = splited[j];
            }
        }

//        dfs(map, visited, startY, startX, 1, 0, 0);
        bfs(map, visited, startY, startX, endY, endX);

        return answer;
    }

    private int bfs(String[][] map, boolean[][] visited, int startY, int startX, int endY, int endX) {

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startY, startX, 0));
        visited[startY][startX] = true;

        while (!q.isEmpty()) {
            Point poll = q.poll();

            if (poll.getY() == endY && poll.getX() == endX) {
                return poll.getLv();
            }

            for (int i = 0; i < 4; i++) {
                int ny = poll.getY();
                int nx = poll.getX();

                while (ny >= 0 && ny <= map.length-1 && nx >= 0 && nx <= map.length-1 && !map[ny][nx].equals("D")) {
                    ny += dy[i];
                    nx += dx[i];
                }

                // 범위를 벗어나거나 장애물 만나기 직전일때
                ny -= dy[i];
                nx -= dx[i];

                // 방문 하거나 같은 위치일 경우 스킵
                if (visited[ny][nx] || (poll.getY() == ny && poll.getX() == nx)) {
                    continue;
                }

                visited[ny][nx] = true;
                q.add(new Point(ny, nx, poll.getLv() + 1) );
            }
        }

        return -1;
    }
    public void dfs(String[][] map, boolean[][] visited, int y, int x, int moveCnt, int currentDirIdx, int dirIdx) {
        if (map[y][x].equals("G") && currentDirIdx == dirIdx) {
            answers.add(moveCnt);
            return;
        } else if ("D".equals(map[y][x])) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && ny <= map.length-1 && nx >= 0 && nx <= map.length-1 && !visited[ny][nx]) {
                visited[ny][nx] = true;
                if (currentDirIdx == dirIdx) {
                    dfs(map, visited, ny, nx, moveCnt, i, dirIdx);
                } else {
                    dfs(map, visited, ny, nx, moveCnt + 1, i, dirIdx);
                }
                visited[ny][nx] = false;
            }
        }

    }
}

class Point {

    private int y;
    private int x;
    private int lv;

    public Point(int y, int x, int lv) {
        this.y = y;
        this.x = x;
        this.lv = lv;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getLv() {
        return lv;
    }
}
