package programmers.lv2.test;

/**
 * 문제: 행렬의 곱셈 #91 - Level 2
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12949
 * 문제 풀이: https://github.com/Irisation23/Java_Algorithm/issues/91
 */
public class Problem04 {
    class Solution {
        public int[][] solution(int[][] arr1, int[][] arr2) {
            int[][] answer = new int[arr1.length][arr2[0].length];

            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr2[i].length; j++) {
                    for (int k = 0; k < arr1[i].length; k++) {
                        answer[i][j] += arr1[i][k] * arr2[k][j];
                    }
                }
            }

            return answer;
        }
    }
}
