package codetree.data_structured.stack;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 괄호 문자열의 적합성 판단
 * 10XP
 * 보통
 * 정답률 51%
 *  ·
 * 제출 1,188회
 *  ·
 * 예상 소요 시간 12분
 * Like
 * 8
 * Dislike
 * 아쉬워요
 * 1 Star
 *
 * Empty
 * 내 리스트에 추가
 * 괄호 문자열은 두 개의 괄호 기호인 ' ( ' 와 ' ) ' 만으로 구성되어 있는 문자열입니다. 괄호 문자열은 다음과 같이 2가지로 분류할 수 있습니다.
 *
 * 올바른 괄호 문자열 : 괄호를 열고 닫음이 분명한 문자열을 말합니다. 다음과 같은 문자열은 올바른 괄호 문자열입니다.
 *  "()"
 *  "(())"
 *  "(()())"
 * 올바르지 못한 괄호 문자열 : 괄호를 열고 닫음이 분명하지 못한 문자열을 말합니다. 다음과 같은 문자열은 올바르지 못한 괄호 문자열입니다.
 *  "(("
 *  "(()("
 *  "(((())"
 * 입력으로 주어진 괄호 문자열이 올바른지, 그렇지 못한지를 판단하여 결과를 출력하는 프로그램을 작성하세요.
 *
 * 입력 형식
 * 첫 번째 줄에 하나의 괄호 문자열이 한 줄에 공백없이 주어집니다.
 *
 * 2≤ 괄호 문자열의 길이 ≤50
 * 출력 형식
 * 첫 번째 줄에 입력 괄호 문자열이 올바른 괄호 문자열이면 Yes, 아니면 No를 출력합니다.
 */
public class 스택_괄호_문자열의_적합성_판단 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) {
        Stack<String> strings = new Stack<>();
        String shape = next();
        String[] shapes = shape.split("");

        boolean flag = false;
        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i].equals("(")) {
                strings.push(shapes[i]);
            } else {
                if (!strings.empty()) {
                    strings.pop();
                } else {
                    continue;
                }
            }

            if (i == shapes.length - 1 && strings.empty()) {
                flag = true;
            }
        }

        if (flag) {
            System.out.println("Yes");
            return;
        }

        System.out.println("No");
    }

    static String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}
