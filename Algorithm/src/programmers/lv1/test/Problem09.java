package programmers.lv1.test;

/**
 * 문제: 3진법 뒤집기 - Level 1
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/68935
 * 문제 풀이: https://github.com/Irisation23/Java_Algorithm/issues/95
 */
public class Problem09 {

}

class Problem09Solution {
    public int solution(int n) {
        String nToTernary = Integer.toString(n, 3);
        StringBuilder result = new StringBuilder();

        for (char c : nToTernary.toCharArray()) {
            result.append(c);
        }

        return Integer.parseInt(result.reverse().toString(), 3);
    }
}