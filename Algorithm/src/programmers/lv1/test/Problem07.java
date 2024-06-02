package programmers.lv1.test;

import java.util.ArrayList;

/**
 * 문제: 이상한 문자 만들기 - Level 1
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12930
 * 문제 풀이: https://github.com/Irisation23/Java_Algorithm/issues/95
 */
public class Problem07 {

    public static void main(String[] args) {
        Problem07Solution problem07Solution = new Problem07Solution();
//        System.out.println(problem07Solution.solution("try hello world"));
        System.out.println(problem07Solution.solution("t"));
    }
}

class Problem07Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder result = new StringBuilder();

        ArrayList<char[]> arrayLists = new ArrayList<>();
        String[] s1 = s.split(" ");

        for (int i = 0; i < s1.length; i++) {
            arrayLists.add(s1[i].toCharArray());
        }

        for (int i = 0; i < arrayLists.size(); i++) {
            for (int j = 0; j < arrayLists.get(i).length; j++) {
                char[] chars = arrayLists.get(i);

                if (j % 2 == 0) {
                    result.append(Character.toUpperCase(chars[j]));
                } else {
                    result.append(Character.toLowerCase(chars[j]));
                }

                result.append(" ");
            }
        }

        if (!result.isEmpty()) {
            result.deleteCharAt(result.length() -1);
        }

        return result.toString();
    }
}