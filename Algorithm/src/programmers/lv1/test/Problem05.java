package programmers.lv1.test;

/**
 * 문제: 자연수 뒤집어 배열로 만들기
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12932
 * 문제 풀이: https://github.com/Irisation23/Java_Algorithm/issues/93
 */
public class Problem05 {

}

class Problem05Solution {
    public int[] solution(long n) {
        // 12345
        StringBuilder nToStringBuilder = new StringBuilder(String.valueOf(n));  // "12345"
        String nToString = nToStringBuilder.reverse().toString(); // "54321"

        int[] answer = new int[nToString.length()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] =  nToString.charAt(i) - '0';
        }

        return answer;
    }
}
