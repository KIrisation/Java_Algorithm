package baekjoon.solved.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackSequence {

    static int N;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(reader.readLine());

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }

        Stack<Integer> stack = new Stack<>();
        int listIdx = 0;
        int stackNum = 1;

        while (true) {
            if (!stack.isEmpty() && stack.peek().equals(list.get(listIdx))) {
                ++listIdx;
                stack.pop();
                sb.append("-\n");

                continue;
            }

            if (stackNum > N) {
                break;
            }

            stack.push(stackNum++);
            sb.append("+\n");
        }

        if (stack.isEmpty()) {
            System.out.println(sb.toString());
        } else {
            System.out.println("NO");
        }
    }
}
