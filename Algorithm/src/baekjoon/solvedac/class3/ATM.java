package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ATM {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(reader.readLine());
        String[] s= reader.readLine().split(" ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(s[i]));
        }

        list.sort(Comparator.naturalOrder()); // 1 2 3 3 4

        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j <= i; j++) {
                sum += list.get(j);
            }
        }

        System.out.println(sum);
    }
}
