package programmers.lv0.day13;

import java.util.Stack;

/**
 * 숫자들이 공백으로 구분된 문자열이 주어집니다.
 * 문자열에 있는 숫자를 차례대로 더하려고 합니다.
 * 이 때 "Z"가 나오면 바로 전에 더했던 숫자를 뺀다는 뜻입니다.
 * 숫자와 “Z”로 이루어진 문자열 s가 주어질때,
 * 머쓱이가 구한 값을 return 하도록 solution 함수를 완성해보세요.
 */
public class CtrlZ {

    public static void main(String[] args) {
        System.out.println(solution("1 2 Z 3"));
        System.out.println(solution("10 20 30 40"));
        System.out.println(solution("10 Z 20 Z 1"));
        System.out.println(solution("1 1 Z Z"));
    }

    public static int solution(String s) {
        int sum = 0;

        Stack<Integer> integerStack = new Stack<>();
        String[] split = s.split(" ");

        for (String x : split) {
            if (x.equals("Z")) {
                if (integerStack.isEmpty()) {
                    continue;
                }
                integerStack.pop();
                continue;
            }

            integerStack.push(Integer.parseInt(x));
        }

        while(!integerStack.isEmpty()) {
            sum += integerStack.pop();
        }

        return sum;
    }
}
