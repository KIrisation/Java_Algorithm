package programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TopAndBottomOfLottery {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19})[0]);
        System.out.println(solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19})[1]);
    }

    public static int[] solution(int[] lottos, int[] win_nums) {

        List<Integer> result = new ArrayList<>();

        int correctCnt = 0;
        int zeroCnt = 0;

        List<Integer> winNums = Arrays.stream(win_nums)
                                      .boxed()
                                      .collect(Collectors.toList());

        for (int lotto : lottos) {
            if (lotto == 0) {
                ++zeroCnt;
            }
            if (winNums.contains(lotto)) {
                ++correctCnt;
            }
        }

        int maxRankingCnt = correctCnt + zeroCnt;

        int maxRanking = 7 - maxRankingCnt;
        if (maxRanking > 6) {
            maxRanking = 6;
        }

        int minRanking = 7 - correctCnt;
        if (minRanking > 6) {
            minRanking = 6;
        }

        result.add(maxRanking);
        result.add(minRanking);

        return result.stream()
                     .mapToInt(i -> i)
                     .toArray();
    }
}
