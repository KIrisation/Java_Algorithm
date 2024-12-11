package baekjoon.solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class 나이순_정렬 {

    static class People implements Comparable<People> {
        int idx;
        int age;
        String name;

        public People(int idx, int age, String name) {
            this.idx = idx;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(People o) {
            if (this.age - o.age == 0) {
                return this.idx - o.idx;
            }

            return this.age - o.age;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        List<People> pq = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] s = reader.readLine().split(" ");
            pq.add(new People(i, Integer.parseInt(s[0]), s[1]));
        }

        Collections.sort(pq);

        for (People people : pq) {
            System.out.println(people.age + " " + people.name);
        }
    }
}
