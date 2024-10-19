package programmers.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 올바른_괄호 {

    boolean solution(String s) {
        // 길이가 홀수 인 경우 짝이 맞을 수 없음.
        if(s.length() % 2 == 1) {
            return false;
        }

        if(s.charAt(0) == ')') {
            return false;
        }

        boolean answer = true;
        char[] charArray = s.toCharArray();

        List<String> sArray = new ArrayList<>();
        for (char c : charArray) {
            sArray.add(String.valueOf(c));
        }

        Stack<String> strings = new Stack<>();
        for (int i = 0; i < sArray.size(); i++) {
            if (strings.isEmpty()) {
                strings.push(sArray.get(i));
            }

            if (strings.peek().equals("(") && sArray.get(i).equals(")")) {
                strings.pop();
            }
        }


        if (!strings.isEmpty()) {
            answer = false;
        }

        return answer;
    }

    public static void main(String[] args) {
        올바른_괄호 solution = new 올바른_괄호();
        solution.solution("(())()");
    }
}
