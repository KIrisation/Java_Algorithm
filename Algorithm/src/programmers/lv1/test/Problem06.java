package programmers.lv1.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 문제: 시저 암호 - Level 1
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12926
 * 문제 풀이: https://github.com/Irisation23/Java_Algorithm/issues/94
 */
public class Problem06 {

    public static void main(String[] args) {
        Problem06Solution solution = new Problem06Solution();
        System.out.println(solution.solution("A B Z", 25));
    }
}

class Problem06Solution {

    public String solution(String s, int n) {

        StringBuilder answer = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                char shifted = (char) ((c - base + n) % 26 + base); // 핵심
                answer.append(shifted);
            } else {
                answer.append(c);
            }
        }

        return answer.toString();
    }
}
