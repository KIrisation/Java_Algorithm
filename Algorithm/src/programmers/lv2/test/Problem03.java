package programmers.lv2.test;

/**
 * 문제: 거리두기 확인하기 - Level 2
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/81302#fn1
 * 문제 풀이: https://github.com/Irisation23/Java_Algorithm/issues/90
 */
public class Problem03 {

    public static void main(String[] args) {
        String[][] hello = {
            {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
            {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
            {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
            {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
            {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        Solution solution = new Solution();
        int[] result = solution.solution(hello);
        for (int r : result) {
            System.out.println(r);
        }
    }
}

class Solution {
    private static final int[] dx = {0, -1, 1, 0};
    private static final int[] dy = {-1, 0, 0, 1};

    private boolean isNextToVolunteer(char[][] room, int x, int y, int exclude) {
        for (int d = 0; d < 4; d++) {
            if (d == exclude) {
                continue;
            }

            int nx = x + dx[d];
            int ny = y + dy[d];

            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) {
                continue;
            }

            if (room[ny][nx] == 'P') {
                return true;
            }
        }

        return false;
    }

    private boolean isDistanced(char[][] room, int x, int y) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) {
                continue;
            }

            switch (room[ny][nx]) {
                case 'P':
                    return false;
                case 'O':
                    if (isNextToVolunteer(room, nx, ny, 3 -d)) {
                        return false;
                    }
                    break;

            }
        }

        return true;
    }

    private boolean isDistanced(char[][] room) {
        for (int y = 0; y < room.length; y++) {
            for (int x = 0; x < room[y].length; x++) {
                if (room[y][x] != 'P') {
                    continue;
                }

                if (!isDistanced(room, x, y)) {
                    return false;
                }
            }
        }

        return true;
    }

    public int[] solution(String[][] places) {
        int[] result = new int[places.length];

        for (int i = 0; i < result.length; i++) {
            String[] place = places[i];
            char[][] room = new char[place.length][];

            for (int j = 0; j < room.length; j++) {
                room[j] = place[j].toCharArray();

            }

            if (isDistanced(room)) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }
        }

        return result;
    }
}