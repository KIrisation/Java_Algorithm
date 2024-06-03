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
        System.out.println(problem07Solution.solution(" t     jj  jjjj    "));
//        System.out.println(problem07Solution.solution("disappeared aPpEaReD").equals("DiSaPpEaReD ApPeArEd"));
        System.out.println("a b1                 c");
    }
}

class Problem07Solution {
    public String solution(String s) {
//        s = s.replaceAll("\\s+", " "); // 띄어쓰기가 여러개일 경우 무조건 띄어쓰기 하나로 바꿔주는 정규 표현식
        StringBuilder result = new StringBuilder();

        ArrayList<char[]> arrayLists = new ArrayList<>();
        String[] s1 = s.split(" ", -1);

        for (int i = 0; i < s1.length; i++) {
//            if (s1[i].isEmpty()) { // 정규 표현식이 없을 때 띄어쓰기 싹다 지우는 방법
//                continue;
//            }
            arrayLists.add(s1[i].toCharArray());
        }

        for (int i = 0; i < arrayLists.size(); i++) {
            for (int j = 0; j < arrayLists.get(i).length; j++) {
                char c = arrayLists.get(i)[j];

                if (j % 2 == 0) {
                    result.append(Character.toUpperCase(c));
                } else {
                    result.append(Character.toLowerCase(c));
                }
            }
            result.append(" ");
        }


        result.deleteCharAt(result.length() -1);

        return result.toString();
    }
}