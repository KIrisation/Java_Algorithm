package programmers.lv1;

import java.util.HashSet;
import java.util.Set;

/**
 * 해당 문제는 풀이가 필요없다고 생각함.
 */
public class Phoneketmon {
    public int solution(int[] nums) {
        Set<Integer> phoneketmonType = new HashSet<>();
        for (int num : nums) {
            phoneketmonType.add(num);
        }
        return Math.min(phoneketmonType.size(), nums.length / 2);
    }
}
