package baekjoon.solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.function.ToIntFunction;

/**
 * https://www.acmicpc.net/problem/9012
 */
public class 괄호 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            String[] s = reader.readLine().split("");
            for (String shape : s) {
                if ("(".equals(shape)) {
                    stack.push(shape);
                } else {
                    if (stack.isEmpty()) {
                        stack.push(shape);
                    } else if ("(".equals(stack.peek())){
                        stack.pop();
                    }
                }
            }

            if (stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

            stack.clear();
        }
    }
}
