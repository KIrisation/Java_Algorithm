package baekjoon.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class NumberSort2 {

}

class MainNumberSort2 {

    static FastReader fastReader = new FastReader();

    static List<Integer> numbers = new ArrayList<>();
    static Map<Integer, Integer> modes = new HashMap<>();
    static int N; // 수의 개수
    static int arithmeticMean; // 산술통계
    static int middleValue; // 중앙 값
    static int mode; // 최빈 값
    static int range; // 범위


    public static void main(String[] args) throws IOException {
        input();
        calculateArithmeticMean();
        calculateMiddleValue();
        calculateMode();
        calculateRange();
        output();
    }

    static void input() {
        N = fastReader.nextInt();

        for (int i = 0; i < N; i++) {
            numbers.add(fastReader.nextInt());
        }
    }

    private static void calculateArithmeticMean() {
        arithmeticMean = (int) (Math.round(numbers.stream()
                                                  .mapToInt(i -> i)
                                                  .sum() / (double) numbers.size()));
    }

    private static void calculateMiddleValue() {
        numbers.sort(Comparator.naturalOrder());

        middleValue = numbers.get((numbers.size() / 2));
    }

    private static void calculateMode() {
        for (Integer number : numbers) {
            modes.compute(number, (k, v) -> v == null ? 1 : ++v);
        }

        List<Map.Entry<Integer, Integer>> entries = new LinkedList<>(modes.entrySet());

        entries.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey() - o2.getKey();
            }

            return o2.getValue() - o1.getValue();
        }); // 카운팅 된 친구의 키

        if (entries.size() > 1 && entries.get(0).getValue().equals(entries.get(1).getValue())) {
            mode = entries.get(1).getKey();
        } else {
            mode = entries.get(0).getKey();
        }
    }

    private static void calculateRange() {
        range = numbers.get(numbers.size() - 1) - numbers.get(0);
    }

    private static void output() throws IOException {
        fastReader.output();
    }

    static class FastReader {

        BufferedReader br;
        BufferedWriter bw;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        void output() throws IOException {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(arithmeticMean)
                         .append("\n")
                         .append(middleValue)
                         .append("\n")
                         .append(mode)
                         .append("\n")
                         .append(range);
            System.out.println(stringBuilder);
        }
    }
}
