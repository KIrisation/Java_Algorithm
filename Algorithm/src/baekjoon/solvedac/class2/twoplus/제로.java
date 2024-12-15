package baekjoon.solvedac.class2.twoplus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 제로 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int K = Integer.parseInt(reader.readLine());

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < K; i++) {
            int i1 = Integer.parseInt(reader.readLine());
            if (i1 == 0) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }

            stack.push(i1);
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        writer.write(String.valueOf(sum));
        writer.flush();
    }
}
