package programmers.lv2.fail;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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

//        int startToLever = bfs(maps, startY, startX, leverY, leverX, visited); // 시작 -> 레버
//        if (startToLever == -1) {
//            return -1;
//        }
//
//        int leverToEnd = bfs(maps, leverY, leverX, endY, endX, visited); // 레버 -> 도착
//        if (leverToEnd == -1) {
//            return -1;
//        }
//
//        return startToLever + leverToEnd;

        int[][] dist = new int[maps.length][maps[0].length()];
        for (int[] ints : dist) {
            Arrays.fill(ints, -1);
        }

        bfs2(maps, startY, startX, dist);
        int startToLever = dist[leverY][leverX];
        if (startToLever == -1) {
            return -1;
        }

        // 어떤 노드에서 그 외 모든 노드의 최단 거리 값을 가질라면
        dist = new int[maps.length][maps[0].length()];
        for (int[] ints : dist) {
            Arrays.fill(ints, -1);
        }
        bfs2(maps, leverY, leverX, dist);
        int leverToEnd = dist[endY][endX];
        if (leverToEnd == -1) {
            return -1;
        }

        return startToLever + leverToEnd;
    }

    public int bfs(String[] maps, int startY, int startX, int endY, int endX,
        boolean[][] visited) { // bfs는 언제 끝날지 몰라, visited는 int 값으로 관리했어야 했다.
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(startY, startX, 0));

        while (!q.isEmpty()) {
            Point poll = q.poll();

            if (endY == poll.getY() && endX == poll.getX()) {
                return poll.getStep();
            }

            for (int i = 0; i < 4; i++) {
                int ny = poll.getY() + dy[i];
                int nx = poll.getX() + dx[i];

                if (ny >= 0 && ny <= maps.length - 1 && nx >= 0 && nx <= maps[0].length() - 1
                    && maps[ny].charAt(nx) != 'X' && !visited[ny][nx]) { // visited는 궂이 필요없었음.
                    visited[ny][nx] = true;
                    q.offer(new Point(ny, nx, poll.getStep() + 1));
                }
            }
        }

        return -1;
    }

    public void bfs2(String[] maps, int startY, int startX, int[][] dist) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(startY, startX, 0));

        while (!q.isEmpty()) {
            Point poll = q.poll();
            int currentY = poll.getY();
            int currentX = poll.getX();

            for (int i = 0; i < 4; i++) {
                int nextY = poll.getY() + dy[i];
                int nextX = poll.getX() + dx[i];

                if (nextY >= 0 && nextY <= maps.length - 1 && nextX >= 0 && nextX <= maps[0].length() - 1
                    && maps[nextY].charAt(nextX) != 'X' && dist[nextY][nextX] == -1) { // visited는 궂이 필요없었음.
                    dist[nextY][nextX] = dist[currentY][currentX] + 1;
                    q.offer(new Point(nextY, nextX, poll.getStep() + 1));
                }
            }
        }
    }
}