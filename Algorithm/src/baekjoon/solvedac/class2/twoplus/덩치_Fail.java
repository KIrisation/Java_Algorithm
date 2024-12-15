package baekjoon.solvedac.class2.twoplus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/7568
 *
 * 해당 문제풀이는 브루트 포스를 기반하여 풀이가 이어졌어야 하나,
 * 정렬에 포커싱을 둬서 문제와 구현을 어렵게 만들어 정답에 근접하지 못한점이 패착으로 기록됨.
 *
 * 브루트 포스를 이용할 수 있는 문제라는게 판단됐다면, 브루트 포스가 우선임을 인지하여 코드를 작성하는
 * 연습이 필요함.
 */
public class 덩치_Fail {

    static int rank = 1;
    static class People implements Comparable<People> {

        private int idx;
        private int weight;
        private int height;
        private int ranking;

        public People(int idx, int weight, int height) {
            this.idx = idx;
            this.weight = weight;
            this.height = height;
            this.ranking = rank;
        }

        public int getIdx() {
            return idx;
        }

        public int getWeight() {
            return weight;
        }

        public int getHeight() {
            return height;
        }

        @Override
        public int compareTo(People o) {
            if (this.getHeight() > o.getHeight() && this.getWeight() > o.getWeight()) {
                o.setRanking(rank);
                ++rank;
                return this.getHeight() - o.getHeight();
            }

            return 0;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getRanking() {
            return ranking;
        }

        public void setRanking(int ranking) {
            this.ranking = ranking;
        }
    }

    public static void main(String[] args) throws IOException {

        /**
         * 5
         * 55 185 1 -> 2
         * 58 183 1 -> 2
         * 88 186 1 2번 인덱스 = 1등 그외 등수는 +1등
         * 60 175 1등과 비교 작음, 2등과 비교 비교할 수 없음 = 2등
         * 46 155 1 cnt 1, 2 cnt 3 이후 등수인 5등
         *
         * Point
         *
         * 1. 앞에 이미 1등이 있었고, 1등이 등장 이미 등수가 매겨진 데이터는 +1
         * 2. 공동 등수를 이길 방법은 공동 등수의 최대키보다 크고, 최대 몸무게보다 크다.
         */

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        List<People> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] s = reader.readLine().split(" ");

            int weight = Integer.parseInt(s[0]);
            int height = Integer.parseInt(s[1]);

            list.add(new People(i, weight, height));
        }

        Collections.sort(list);

        for (int i = 0; i < N; i++) {
            for (People people : list) {
                if (i == people.getIdx()) {
                    System.out.print(people.getRanking() + " ");
                }
            }
        }
    }
}
