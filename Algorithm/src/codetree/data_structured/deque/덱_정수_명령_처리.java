package codetree.data_structured.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 덱_정수_명령_처리 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) {
        int N = nextInt();

        Deque<Integer> q = new ArrayDeque<>();
        String command = null;
        for (int i = 0; i < N; i++) {
            command = next();
            switch (command) {
                case "push_front": {
                    q.addFirst(nextInt());
                    break;
                }

                case "push_back": {
                    q.addLast(nextInt());
                    break;
                }

                case "pop_front": {
                    System.out.println(q.pollFirst());
                    break;
                }

                case "pop_back": {
                    System.out.println(q.pollLast());
                    break;
                }

                case "size": {
                    System.out.println(q.size());
                    break;
                }

                case "empty": {
                    System.out.println(q.isEmpty() ? 1 : 0);
                    break;
                }

                case "front": {
                    System.out.println(q.peekFirst());
                    break;
                }

                case "back": {
                    System.out.println(q.peekLast());
                    break;
                }

                default: {
                    break;
                }
            }
        }
    }

    public static String next() {
        while(st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(reader.readLine());
            } catch(IOException e) {
            }
        }

        return st.nextToken();
    }

    public static int nextInt() {
        return Integer.parseInt(next());
    }
}
