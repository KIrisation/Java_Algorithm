package baekjoon.solvedac.class2.plus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 큐 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int commandNum = Integer.parseInt(reader.readLine());
        LinkedList<Integer> queue = new LinkedList<>();

        while (commandNum-- > 0) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    int value = Integer.parseInt(st.nextToken());
                    queue.add(value);
                    break;
                case "pop":
                    writer.write(queue.isEmpty() ? "-1" : String.valueOf(queue.poll()));
                    writer.newLine();
                    break;
                case "size":
                    writer.write(String.valueOf(queue.size()));
                    writer.newLine();
                    break;
                case "empty":
                    writer.write(queue.isEmpty() ? "1" : "0");
                    writer.newLine();
                    break;
                case "front":
                    writer.write(queue.isEmpty() ? "-1" : String.valueOf(queue.peek()));
                    writer.newLine();
                    break;
                case "back":
                    writer.write(queue.isEmpty() ? "-1" : String.valueOf(queue.getLast()));
                    writer.newLine();
                    break;
            }
        }

        writer.flush();
    }
}
