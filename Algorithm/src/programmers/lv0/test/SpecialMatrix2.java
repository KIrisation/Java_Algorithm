package programmers.lv0.test;

/**
 * 문제: 특별한 행렬 2 - lv0
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/181831
 */
public class SpecialMatrix2 {
}

class SpecialMatrix2Solution {

    public int solution(int[][] arr) {
        int answer = 1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != arr[j][i]) {
                    return 0;
                }
            }
        }

        return answer;
    }
}
