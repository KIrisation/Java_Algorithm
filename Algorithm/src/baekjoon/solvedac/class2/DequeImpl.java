package baekjoon.solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 백준 10866번: 덱
 */
public class DequeImpl {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    public static void main(String[] args) {
        N = nextInt();

        Deque<Integer> deque = new LinkedList<>();
        String command;
        for (int i = 1; i <= N; i++) {
            command = next();

            if (command.equals("push_back")) {
                deque.addLast(nextInt());
            } else if (command.equals("push_front")) {
                deque.addFirst(nextInt());
            } else if(command.equals("front")) {
                if (deque.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(deque.getFirst()).append("\n");
                }
            } else if(command.equals("back")) {
                if (deque.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(deque.getLast()).append("\n");
                }
            } else if (command.equals("size")) {
                sb.append(deque.size()).append("\n");
            } else if (command.equals("empty")) {
                if (deque.isEmpty()) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            } else if (command.equals("pop_front")) {
                if (deque.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(deque.pollFirst()).append("\n");
                }
            } else if (command.equals("pop_back")) {
                if (deque.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(deque.pollLast()).append("\n");
                }
            }
        }

        System.out.println(sb);
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

