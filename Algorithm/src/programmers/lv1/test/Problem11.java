package programmers.lv1.test;

/**
 * 문제: 문자열 내 p와 y의 개수 - Level 1
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12916
 *
 */
public class Problem11 {

    public static void main(String[] args) {

    }
}

class Problem11Solution {

    boolean solution (String s) {
        int pCnt = 0;
        int yCnt = 0;

        String sUpperCase = s.toUpperCase();

        for (int i = 0; i < sUpperCase.length(); i++) {
            // p갯수 카운트
            if ("P".equals(String.valueOf(sUpperCase.charAt(i)))) {
                pCnt++;
                continue;
            }

            // y갯수 카운트
            if ("Y".equals(String.valueOf(sUpperCase.charAt(i)))) {
                yCnt++;
            }
        }

        return pCnt == yCnt;
    }
}
