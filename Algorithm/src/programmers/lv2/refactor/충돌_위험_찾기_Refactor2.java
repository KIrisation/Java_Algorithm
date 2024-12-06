package programmers.lv2.refactor;

import java.util.LinkedList;
import java.util.Queue;

public class 충돌_위험_찾기_Refactor2 {

    // 각 로봇의 경로를 저장하는 큐 배열.
    // record[i]는 i번 로봇의 경로 큐를 저장함.
    static Queue<int[]>[] record;
    static int robotNums;
    // 결과 값, 위험 구역 카운팅을 저장하는 변수
    static int result;

    public int solution(int[][] points, int[][] routes) {
        robotNums = routes.length;
        record = new LinkedList[robotNums];

        for (int i = 0; i < robotNums; i++) {
            record[i] = new LinkedList<>(); // 각 로봇 경로 큐 초기화
        }

        // 로봇의 이동 경로를 기록하는 함수 호출
        movingRecording(points, routes);
        // 위험 포인트 카운팅
        dangerCounting();

        return result;
    }

    public void movingRecording(int[][] points, int[][] routes) {
        // 로봇 수만큼 반복하여 각 로봇의 경로를 기록
        for (int i = 0; i < robotNums; i++) {
            // 각 로봇의 시작 위치를 설정
            int[] route = routes[i];

            int y = points[route[0] - 1][0];
            int x = points[route[0] - 1][1];

            // 시작 위치를 큐에 추가
            record[i].add(new int[]{y, x});

            // 경로에 따라 다음 목표 위치로 이동
            for (int j = 1; j < route.length; j++) {
                int py = points[route[j] - 1][0]; // 다음 목표 위치의 y좌표
                int px = points[route[j] - 1][1]; // 다음 목표 위치의 x좌표

                // y 좌표를 먼저 맞춘 후에 x  좌표 이동
                while (py != y) {
                    if (py > y) {
                        y++; // 목표 y 좌표가 더 크면 y를 증가
                    } else {
                        y--; // 목표 y 좌표가 더 작으면 y를 감소
                    }

                    // 이동한 좌표를 큐에 기록
                    record[i].add(new int[]{y, x});
                }

                // x 좌표 이동 처리
                while (px != x) {
                    if (px > x) {
                        x++;
                    } else {
                        x--;
                    }

                    // 이동한 좌표를 큐에 기록
                    record[i].add(new int[]{x, y});
                }
            }
        }
    }

    // 로봇이 이동한 위치에 대해 위험 지역을 카운팅
    public void dangerCounting() {
        int cnt = 0; // 경로가 끝난 로봇의 수를 카운트

        // 모든 로봇의 경로가 끝날 때까지 반복
        while (cnt < robotNums) {
            int[][] map = new int[101][101];
            cnt = 0; // 현재 반복에서 경로가 끝난 로봇 수 초기화

            // 각 로봇의 다음 이동 경로를 맵에 기록
            for (int i = 0; i < robotNums; i++) {
                if (record[i].isEmpty()) { // 해당 로봇이 더 이상 이동할 경로가 없다면
                    cnt++; // 경로가 끝나 로봇 수 증가
                    continue;
                }

                // 로봇의 다음 좌표를 꺼내어 해당 좌표에 기록
                int[] tmp = record[i].poll();
                map[tmp[0]][tmp[1]]++; // 좌표에 지나간 횟수를 기록
            }

            // 맵에서 두 개 이상의 로봇이 지나간 좌표를 카운트
            for (int i = 0; i < 101; i++) {
                for (int j = 0; j < 101; j++) {
                    if (map[i][j] > 1) {
                        result++;
                    }
                }
            }
        }
    }
}
