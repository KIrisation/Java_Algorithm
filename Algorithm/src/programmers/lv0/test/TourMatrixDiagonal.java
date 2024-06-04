package programmers.lv0.test;

/**
 * 문제: 이차원 배열 대각선 순회하기 - lv0
 * 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/181829
 */
public class TourMatrixDiagonal {

}

class TourMatrixDiagonalSolution {

    public int solution(int[][] board, int k) {
        int answer = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (i + j <= k) {
                    answer += board[i][j];
                }
            }
        }

        return answer;
    }
}