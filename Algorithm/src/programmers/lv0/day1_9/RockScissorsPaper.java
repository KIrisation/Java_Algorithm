package programmers.lv0.day1_9;

import java.util.Arrays;

public class RockScissorsPaper {

    public static void main(String[] args) {
        System.out.println(solution("205"));
    }

    public static String solution(String rsp) {
        int[] rspValues = Arrays.stream(rsp.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        StringBuilder sb = new StringBuilder();
        for (int rspValue : rspValues) {
            if (rspValue == 2) {
                sb.append(0);
            }

            if (rspValue == 0) {
                sb.append(5);
            }

            if (rspValue == 5) {
                sb.append(2);
            }
        }

        return sb.toString();
    }

}
