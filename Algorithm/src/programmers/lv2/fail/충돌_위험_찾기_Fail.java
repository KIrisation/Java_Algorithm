package programmers.lv2.fail;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 해당 문제 실패이유는 각 로봇 이동 기록을 단순히 로봇 하나씩 움직일 것을 생각하여 계산하게 되면은
 * 시간별로 해당 위치에 다른 로봇과의 접점을 파악할 수 없었다.
 *
 */
public class 충돌_위험_찾기_Fail {

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public int solution(int[][] points, int[][] routes) {
        int answer = 0;


        int maxY = Integer.MIN_VALUE;
        int maxX = Integer.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            int y = points[i][0];
            int x = points[i][1];

            maxY = Math.max(y, maxY);
            maxX = Math.max(x, maxX);
        }

        System.out.println(maxY);
        System.out.println(maxX);

        int[][] maps = new int[maxY + 1][maxX + 1];
        for (int i = 0; i < maps.length; i++) {
            Arrays.fill(maps[i], -1);
        }

        for (int i = 0; i < points.length; i++) {
            int y = points[i][0];
            int x = points[i][1];

            maps[y][x] = 1;
        }

        for (int[] route : routes) {
            Queue<Integer> q = new LinkedList<>();
            q.add(1);
            while (!q.isEmpty()) {
                int dist = q.poll();
                int startIdx = route[0];
                int endIdx = route[1];

                int startY = points[startIdx - 1][0];
                int startX = points[startIdx - 1][1];

                int endY = points[endIdx - 1][0];
                int endX = points[endIdx - 1][1];

                dfs(startY, startX, endY, endX, dist);

            }
        }

        return answer;
    }

    public void dfs(int startY, int startX, int endY, int endX, int dist) {
        if (startY == endY && startX == endX) {

        }

        if (startY > endY) { // 시작점이 상승하는 코스인 경우
            startY--;
            if (startX > endX) { // X 좌표를 좌측으로 이동해야하는 경우
                startX--;
            }

            if (startX == endX) {// 시작점은 상승해야하나 X좌표는 같은 경우 (단순 수직상승)
            }

            if (startX < endX) { // X 좌표를 우측으로 이동해야하는 경우

            }

        }

        if (startY == endY) { // 시작점이 Y좌표가 같은 경우
            if (startX > endX) { // X 좌표를 좌측으로 이동해야하는 경우

            }

            if (startX == endX) {

            }

            if (startX < endX) { // X 좌표를 우측으로 이동해야하는 경우

            }
        }

        if (startY < endY) { // 시작점이 하강하는 코스인 경우
            if (startX > endX) { // X 좌표를 좌측으로 이동해야하는 경우

            }

            if (startX == endX) {

            }

            if (startX < endX) { // X 좌표를 우측으로 이동해야하는 경우

            }
        }
    }
}
