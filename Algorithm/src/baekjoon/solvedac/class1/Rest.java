package baekjoon.solvedac.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Rest {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        Set<Integer> results = new HashSet<>();

        for (int i = 1; i <= 10; i++) {
            results.add(Integer.parseInt(reader.readLine()) % 42);
        }

        System.out.println(results.size());
    }
}
