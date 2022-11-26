package programmers.lv0.day23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpeciallySort2 {

    public static void main(String[] args) {

    }

    public static int[] solution(int[] numlist, int n) {
        List<Distance> distanceList = new ArrayList<>();

        for (int i = 0; i < numlist.length; i++) {
            distanceList.add(new Distance(numlist[i], Math.abs(n - numlist[i])));
        }

        Collections.sort(distanceList);

        return distanceList.stream()
                           .mapToInt(Distance::getNum)
                           .toArray();
    }

}
class Distance implements Comparable<Distance> {
    private int num;
    private int dist;

    public Distance(int num, int dist) {
        this.num = num;
        this.dist = dist;
    }

    public int getNum() {
        return num;
    }

    // 본인이 클 때 바꿔야한다.
    // 해당 메서드는 리턴을 양수로 할 때 바꾼다.
    @Override
    public int compareTo(Distance o) {
        if (this.dist == o.dist) {
            if (this.num > o.num) {
                return - 1;
            } else if (this.num == o.num) {
                return 0; // 0 이면 안 바꾼다.
            }

            return 1;
        }

        if (this.dist > o.dist) {
            return 1;
        }

        return this.dist - o.dist;
    }
}
