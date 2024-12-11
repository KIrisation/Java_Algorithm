package baekjoon.solvedac.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 백준 10818번: 최소, 최대
 */
public class MinMax {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer> nums = new ArrayList<>();
    static int max, min;
    public static void main(String[] args) throws IOException {
        calculate();
        output();
    }

    private static void calculate() throws IOException {
        int N = Integer.parseInt(br.readLine());

        List<Integer> collect = Arrays.stream(br.readLine().split(" "))
                                      .mapToInt(Integer::parseInt)
                                      .boxed()
                                      .collect(Collectors.toList());

        min = collect.stream().mapToInt(i -> i).min().orElseThrow();
        max = collect.stream().mapToInt(i -> i).max().orElseThrow();
    }

    private static void output() {
        StringBuilder sb = new StringBuilder();

        sb.append(min)
          .append(" ")
          .append(max);

        System.out.println(sb);
    }
}
