package programmers.lv0.test;

import java.util.Arrays;

/**
 * 문제: 특별한 행렬 1 - lv0
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/181833
 */
public class SpecialMatrix1 {


    public static void main(String[] args) {
        SpecialMatrix1Solution solution = new SpecialMatrix1Solution();
        System.out.println(Arrays.deepToString(solution.solution(4)));
    }
}

class SpecialMatrix1Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    answer[i][j] = 1;
                }
            }
        }

        return answer;
    }
}