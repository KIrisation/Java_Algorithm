package programmers.lv0.day23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ranking {

    public static void main(String[] args) {
        System.out.println();
    }

    public static int[] solution(int[][] score) {
        List<IndexRanking> list = new ArrayList<>();

        for (int i = 0; i < score.length; i++) {
            list.add(new IndexRanking(i, (((double) score[i][0] + score[i][1]) / 2.0)));
        }

        Collections.sort(list);

        for (int i = 0; i < score.length; i++) {
            list.get(i).setRanking(i + 1);
        }

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getAverage() == list.get(j).getAverage()) {
                    list.get(j).setRanking(list.get(i).getRanking());
                }
            }
        }

        int[] answer = new int[list.size()];
        for (IndexRanking indexRanking : list) {
            answer[indexRanking.getIdx()] = indexRanking.getRanking();
        }

        return answer;
    }
}

class IndexRanking implements Comparable<IndexRanking> {

    private int idx;
    private double average;
    private int ranking;

    public IndexRanking(int idx, double average) {
        this.idx = idx;
        this.average = average;
    }

    // 양수면 바꾼다.
    @Override
    public int compareTo(IndexRanking o) {
        if (o.average - this.average > 0) {
            return 1;
        } else if (o.average - this.average == 0) {
            return 0;
        }

        return -1;
    }

    public int getIdx() {
        return idx;
    }

    public double getAverage() {
        return average;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getRanking() {
        return ranking;
    }
}