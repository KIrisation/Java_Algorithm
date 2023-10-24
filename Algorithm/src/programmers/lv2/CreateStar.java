package programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 난이도: lv2
 * 문제: 교점에 별 만들기
 * 링크 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/87377">...</a>
 *
 * 문제 풀이 순서 - 프로그래머스 코딩테스트 문제풀이 전략 자바 편 참조
 *
 * 1. 모든 직선 쌍에 대해 반복
 * - A. 교점 좌표 구하기
 * - B. 정수 좌표만 저장
 * 2. 저장된 정수들에 대해 x,y 좌표의 최댓값, 최솟값 구하기
 * 3. 구한 최댓값, 최솟값을 이용하여 2차원 배열의 크기 결정
 * 4. 2차원 배열에 별 표시
 * 5. 문자열 배열로 변환 후 반환
 */
public class CreateStar {

    private static class Point {
        public final long x;
        public final long y;

        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    // 1-A 교점 좌표 구하기 메서드
    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        // 교점 구해서 반환하기
        double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
        double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);

        // 교점이 정수가 아닐 경우 null 반환
        if (x % 1 != 0 || y % 1 != 0) {
            return null;
        }

        return new Point((long) x, (long) y);
    }

    // 2. 저장된 정수들에 대해 x, y 최솟값 구하기
    private Point getMinimumPoint(List<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for (Point point : points) {
            if (point.x < x) {
                x = point.x;
            }

            if (point.y < y) {
                y = point.y;
            }
        }

        return new Point(x, y);
    }

    // 2. 저장된 정수들에 대해 x, y 좌표의 최댓값
    private Point getMaximumPoint(List<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for (Point point : points) {
            if (point.x > x) {
                x = point.x;
            }

            if (point.y > y) {
                y = point.y;
            }
        }

        return new Point(x, y);
    }

    public String[] solution(int[][] line) {
        //1-B 정수 교점 좌표만 저장
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point intersection = intersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);

                if (intersection != null) {
                    points.add(intersection);
                }
            }
        }

        // 3. 구한 최댓값, 최솟값을 이용하여 2차원 배열의 크기 결정
        Point minimumPoint = getMinimumPoint(points);
        Point maximumPoint = getMaximumPoint(points);

        int width = (int) (maximumPoint.x - minimumPoint.x + 1);
        int height = (int) (maximumPoint.y - minimumPoint.y + 1);

        char[][] arr = new char[height][width];

        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }

        for (Point p : points) {
            int x = (int) (p.x - minimumPoint.x);
            int y = (int) (maximumPoint.y - p.y);
            arr[y][x] = '*';
        }

        String[] answer = new String[arr.length];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = new String(arr[i]);
        }

        return answer;
    }
}
