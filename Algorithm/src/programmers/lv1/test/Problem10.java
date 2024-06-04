package programmers.lv1.test;

/**
 * 문제: 이진 변환 반복하기 - Level 2
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/70129
 * 문제 풀이: https://github.com/Irisation23/Java_Algorithm/issues/98
 */
public class Problem10 {

    public static void main(String[] args) {
        Problem10Solution problem10Solution = new Problem10Solution();
        int[] solution = problem10Solution.solution("110010101001");
        for (int i : solution) {
            System.out.println(i);
        }
    }
}

class Problem10Solution {

    public int[] solution(String s) {
        int iterateCnt = 0;
        int totalRemoveCnt = 0;

        while (!s.equals("1")) {
            iterateCnt++;
            int removeThisTimeZeroCnt = removeCount(s);

            totalRemoveCnt += removeThisTimeZeroCnt;
            s = Integer.toString(s.length() - removeThisTimeZeroCnt, 2);
        }

        return new int[]{iterateCnt, totalRemoveCnt};
    }

    private int removeCount(String s) {
        int cntZero =  0;

        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c == '0') {
                cntZero++;
            }
        }

        return cntZero;
    }
}