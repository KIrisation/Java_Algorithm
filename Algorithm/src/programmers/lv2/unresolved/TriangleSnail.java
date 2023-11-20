package programmers.lv2.unresolved;

/**
 * 난이도: lv2
 * 문제: 삼각 달팽이
 * 링크 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/68645">...</a>
 *
 * 문제 풀이 순서
 *
 * 1. n x n 2차원 배열 선언
 * 2. 숫자를 채울 현재 위치를 (0, 0) 으로 설정
 * 3. 방향에 따라 이동할 수 없을 때까지 반복하면서 숫자 채우기
 * - A. 아래로 이동하면서 숫자 채우기
 * - B. 오른쪽으로 이동하면서 숫자 채우기
 * - C. 왼쪽 위로 이동하면서 숫자 채우기
 * 4. 채워진 숫자를 차례대로 1차원 배열에 옮겨서 반환
 *
 * 미완성 코드임.
 */
public class TriangleSnail {
    // 총 3개의 방향을 사용함.
    // 아래, 오른쪽, 왼쪽 위 그에 따른 dx, dy 선정
    private static final int[] dx = {0, 1, -1};
    private static final int[] dy = {0, 0, -1};

    public static void main(String[] args) {
    }

    public int[] solution(int n) {
        int[] answer = {};

        int [][] triangle = new int[n][n];
        int v = 1;
        int x = 0;
        int y = 0;
        int d = 0;

        while (true) {
            triangle[y][x] = v++;
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
                d = (d + 1) % 3;

                nx = x + dx[d];
                ny = y + dy[d];

                if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
                    break;
                }
            }

            x = nx;
            y = ny;
        }

        int[] result = new int[v - 1];
        int index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result[index++] = triangle[i][j];
            }
        }

        return result;
    }
}
