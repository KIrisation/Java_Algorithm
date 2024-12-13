package baekjoon.solvedac.class2.plus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int commandNum = Integer.parseInt(reader.readLine());
        Stack<Integer> stack = new Stack<>();

        while (commandNum-- > 0) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    int value = Integer.parseInt(st.nextToken());
                    stack.push(value);
                    break;
                case "top":
                    writer.write(stack.isEmpty() ? "-1" : String.valueOf(stack.peek()));
                    writer.newLine();
                    break;
                case "size":
                    writer.write(String.valueOf(stack.size()));
                    writer.newLine();
                    break;
                case "empty":
                    writer.write(stack.isEmpty() ? "1" : "0");
                    writer.newLine();
                    break;
                case "pop":
                    writer.write(stack.isEmpty() ? "-1" : String.valueOf(stack.pop()));
                    writer.newLine();
                    break;
            }
        }

        writer.flush();
    }
}
