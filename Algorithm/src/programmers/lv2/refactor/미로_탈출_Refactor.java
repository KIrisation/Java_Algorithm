package programmers.lv2.refactor;

import java.util.LinkedList;
import java.util.Queue;

public class 미로_탈출_Refactor {
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

        int startToLever = 0;
        startToLever = bfs(maps, startY, startX, leverY, leverX, visited);
        if (startToLever == -1) {
            return -1;
        }

        int leverToEnd = 0;
        visited = new boolean[maps.length][maps[0].length()];
        leverToEnd = bfs(maps, leverY, leverX, endY, endX, visited);
        if (leverToEnd == -1) {
            return -1;
        }
        return startToLever + leverToEnd;
    }

    public int bfs(String[] maps, int startY, int startX, int endY, int endX, boolean[][] visited) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(startY, startX, 0));
        visited[startY][startX] = true;

        while(!q.isEmpty()) {
            Point poll = q.poll();

            if (endY == poll.getY() && endX == poll.getX()) {
                return poll.getStep();
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