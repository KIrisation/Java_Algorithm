package programmers.lv2.refactor;

import java.util.*;

class 리코쳇_로봇_Refactor {
    private static final char ROBOT = 'R';
    private static final char DISABLE = 'D';
    private static final char GOAL = 'G';
    private final int[] dy = {-1, 1, 0, 0};
    private final int[] dx = {0, 0, -1, 1};
    private int n;
    private int m;

    public int solution(String[] board) {
        int answer = 0;

        n = board.length;
        m = board[0].length();

        Pointer robot = null;
        Pointer goal = null;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = board[i].charAt(j);

                if (ch == ROBOT) {
                    robot = new Pointer(i, j, 0);
                } else if (ch == GOAL) {
                    goal = new Pointer(i, j, 0);
                }
            }
        }

        answer = bfs(board, robot, goal);

        return answer;
    }

    private int bfs(String[] board, Pointer robot, Pointer goal) {
        Queue<Pointer> qu = new LinkedList<>();
        qu.add(robot);
        boolean[][] visited = new boolean[n][m];
        visited[robot.y][robot.x] = true;

        while (!qu.isEmpty()) {
            Pointer robotPointer = qu.poll();

            if (robotPointer.y == goal.y && robotPointer.x == goal.x) {
                return robotPointer.depth;
            }

            for (int i = 0; i < 4; i++) {
                int ny = robotPointer.y;
                int nx = robotPointer.x;

                // 범위를 벗어나거나 장애물을 만날 때 까지 반복
                while (inRange(ny, nx) && board[ny].charAt(nx) != DISABLE) {
                    ny += dy[i];
                    nx += dx[i];
                }

                // 범위를 벗어나거나 장애물 만나기 '직전'의 상태
                ny -= dy[i];
                nx -= dx[i];

                // 방문을 하거나 같은 위치일 경우 스킵
                if (visited[ny][nx] || (robotPointer.y == ny && robotPointer.x == nx)) {
                    continue;
                }

                // 방문 하지않았거나, 같은 위치가 아닐때
                visited[ny][nx] = true;
                qu.add(new Pointer(ny, nx, robotPointer.depth + 1));
            }
        }

        return -1;
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && x >= 0 && y < n && x < m;
    }

private class Pointer {
        int y;
        int x;
        int depth;

        public Pointer(int y, int x, int depth) {
            this.y = y;
            this.x = x;
            this.depth = depth;
        }
    }
}