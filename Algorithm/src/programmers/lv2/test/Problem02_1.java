package programmers.lv2.test;

/**
 *
 * 문제: 삼각 달팽이
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/68645
 * 문제 풀이: https://github.com/Irisation23/Java_Algorithm/issues/88
 * 특이 사항: Problem02 코드는 가독성이 낮아 가독성을 개선함.
 *
 */
public class Problem02_1 {

    // private static final int[] dx = {0, 0,-1, 1}; // 상하좌우
    // private static final int[] dy = {-1, 1, 0, 0}; // 상하좌우
    // 실제 상하좌우는 위와 같이 구하나 해당 문제 같은 경우는 하우(상좌)로만 움직이기 때문에 배열의 원소를 3개로 고정
    private static final int[] dx = {0, 1, -1};
    private static final int[] dy = {1, 0, -1};

    public int[] solution(int n) {
        int[][] triangleSnail = new int[n][n];
        int value = 1;
        int x = 0;
        int y = 0;
        int direction = 0; // 0, 1 ,2의 값만 가질 수 있고 각각 하, 우, (상좌)의 방향을 나타냄;

        while (true) {
            triangleSnail[y][x] = value++;
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if (nx == n || ny == n || nx == -1 || ny == -1 || triangleSnail[ny][nx] != 0) {
                direction = (direction + 1) % 3; //방향 전환
                nx = x + dx[direction];
                ny = y + dy[direction];

                if (nx == n || ny == n || nx == -1 || ny == -1 ||triangleSnail[ny][nx] != 0) {
                    break;
                }

                x = nx;
                y = ny;
            }
        }

        int[] result = new int[value - 1];
        int index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result[index++] = triangleSnail[i][j];
            }
        }

        return result;
    }
}
