package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 백준 14501번: 퇴사
 */
public class Leave {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static List<Value> entries = new ArrayList<>();
    static int maxCost = 0;

    public static void main(String[] args) throws IOException {
        input();

        for (int i = 1; i <= N; ++i) {
            if (i + entries.get(i - 1).getKey() - 1 <= N) {
                recursion(i, entries.get(i - 1).getValue());
            }
        }

        System.out.println(maxCost);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(reader.readLine());

        for (int i = 0; i < N; i++) {
            String s = reader.readLine();
            String[] split = s.split(" ");
            entries.add(new Value(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
        }
    }

    // entries.get(i - 1).getKey() 에서 -1을 해주고 안해주는 차이는 다시 일을 할 수 있는지 판단이 필요하기 때문이다.
    private static void recursion(int i, int sum) {
        for (int j = i + entries.get(i - 1).getKey(); j <= N; ++j) { // 다시 상담 할 수 있는 날.
            if (j + entries.get(j - 1).getKey() - 1 <= N) { // 일이 끝나는 날.
                recursion(j, sum + entries.get(j - 1).getValue());
            }
        }

        if (maxCost < sum) {
            maxCost = sum;
        }
    }
}

class Value {

    private int key;
    private int value;

    public Value(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}