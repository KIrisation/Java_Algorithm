package programmers.lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 프로그래머스 lv.2 최댓값과 최솟값
 */
public class MaxMin {

    public static void main(String[] args) {
        solution("1 1");
    }

    public static String solution(String s) {
        String answer = "";
        List<Integer> arr = new ArrayList<>();
        String[] str = s.split(" ");

        for (int i = 0; i < str.length; i++) {
            arr.add(Integer.parseInt(str[i]));
        }

        answer = "" + Collections.min(arr) + " " + Collections.max(arr);

        return answer;
    }
}
