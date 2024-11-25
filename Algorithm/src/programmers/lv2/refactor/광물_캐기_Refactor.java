package programmers.lv2.refactor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 광물_캐기_Refactor {

    static int[][] scoreBoard = new int[][] {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};;
    static List<Mineral> list = new ArrayList<>();

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        int totalPicks = Arrays.stream(picks).sum();

        for (int i = 0; i < minerals.length; i += 5) {
            if (totalPicks == 0) {
                break;
            }

            int dia = 0;
            int iron = 0;
            int stone = 0;

            for (int j = i; j < i + 5; j++) {
                if (j == minerals.length) {
                    break;
                }

                String mineral = minerals[j];

                int value = -1;
                if (mineral.equals("diamond")) {
                    value = 0;
                }

                if (mineral.equals("iron")) {
                    value = 1;
                }

                if (mineral.equals("stone")) {
                    value = 2;
                }

                dia += scoreBoard[0][value];
                iron += scoreBoard[1][value];
                stone += scoreBoard[2][value];
            }

            list.add(new Mineral(dia, iron, stone));
            totalPicks--;
        }

        Collections.sort(list);

        for (Mineral mineral : list) {
            int dia = mineral.getDiamond();
            int iron = mineral.getIron();
            int stone = mineral.getStone();

            if (picks[0] > 0) {
                answer += dia;
                picks[0]--;
                continue;
            }

            if (picks[1] > 0) {
                answer += iron;
                picks[1]--;
                continue;
            }

            if (picks[2] > 0) {
                answer += stone;
                picks[2]--;
            }
        }

        return answer;
    }
    public static void main(String[] args) {


    }
}

class Mineral implements Comparable<Mineral> {
    private int diamond;
    private int iron;
    private int stone;

    public Mineral(int diamond, int iron, int stone) {
        this.diamond = diamond;
        this.iron = iron;
        this.stone = stone;
    }

    public int getDiamond() {
        return diamond;
    }

    public int getIron() {
        return iron;
    }

    public int getStone() {
        return stone;
    }

    @Override
    public int compareTo(Mineral o) {
        return o.stone - this.stone; // 돌 곡괭이를 사용했을 때의 피로도 (최악의 경우)를 기준으로 내림차순 정렬해줌.
    }
}