package programmers.lv2.fail;

import java.util.*;

public class 미로_탈출_Fail {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static class Point {
        private int y;
        private int x;
        private int step;

        public Point(int y, int x, int step) {
            this.y = y;
            this.x = x;
            this.step = step;
        }

        public int getY() {
            return this.y;
        }

        public int getX() {
            return this.x;
        }

        public int getStep() {
            return this.step;
        }
    }

    public int solution(String[] maps) {
        int answer = 0;

        boolean visited[][] = new boolean[maps.length][maps[0].length()];
        int startY = -1;
        int startX = -1;
        int leverY = -1;
        int leverX = -1;
        int endY = -1;
        int endX = -1;
        for (int i = 0; i < maps.length; i++) {
            String[] line = maps[i].split("");

            for (int j = 0; j < line.length; j++) {
                if ("S".equals(line[j])) {
                    visited[i][j] = true;
                    startY = i;
                    startX = j;
                }

                if ("L".equals(line[j])) {
                    leverY = i;
                    leverX = j;
                }

                if ("E".equals(line[j])) {
                    endY = i;
                    endX = j;
                }
            }
        }

        answer = bfs(maps, startY, startX, leverY, leverX, endY, endX, visited);
        return answer;
    }

    public int bfs(String[] maps, int startY, int startX, int leverY, int leverX, int endY, int endX, boolean[][] visited) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(startY, startX, 0));

        boolean isLeverOn = false;
        while(!q.isEmpty()) {
            Point poll = q.poll();

            if (isLeverOn && endY == poll.getY() && endX == poll.getX()) {
                return poll.getStep();
            }

            if (!isLeverOn && leverY == poll.getY() && leverX == poll.getX()) { // 해당 코드에 논리적 오류가 있는데 논리적 오류가 왜 발생하는 지 모르겠음
                isLeverOn = true;
//                visited = new boolean[maps.length][maps[0].length()]; 해결 단계 1. 실패
                // 왜 해당 코드는 시작점 -> 레버 / 레버 -> 도착점 두번의 BFS 탐색이 필요한지에 대해 명확히 모르겠음.
            }

            for (int i = 0; i < 4; i++) {
                int ny = poll.getY() + dy[i];
                int nx = poll.getX() + dx[i];

                if (ny >= 0 && ny <= maps.length - 1 && nx >= 0 && nx <= maps[0].length() - 1 && maps[ny].charAt(nx) != 'X' && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    q.offer(new Point(ny, nx, poll.getStep() + 1));
                }
            }
        }

        return -1;
    }
}