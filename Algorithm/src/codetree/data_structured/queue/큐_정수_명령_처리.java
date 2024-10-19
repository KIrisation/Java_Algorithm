package codetree.data_structured.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 큐_정수_명령_처리 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) {
        int N = nextInt();

        Queue<Integer> q = new LinkedList<>();
        String command = null;
        for (int i = 0; i < N; i++) {
            command = next();
            switch (command) {
                case "push": {
                    q.add(nextInt());
                    break;
                }

                case "pop": {
                    System.out.println(q.poll());
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
                    System.out.println(q.peek());
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
