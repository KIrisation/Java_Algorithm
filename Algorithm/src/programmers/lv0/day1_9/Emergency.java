package programmers.lv0.day1_9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Emergency {
    public int[] solution(int[] sexy) {
        int[] answer = new int[sexy.length];
        List<Injury> list = new ArrayList<>(); // 왜 만들었냐? 정렬을 위함이다.

        for (int i = 0; i < sexy.length; i++) {
            list.add(i, new Injury(i, sexy[i]));
        }

        Collections.sort(list); // {(1,76), (2,24), (0, 3)}

        for (int i = 0; i < list.size(); ++i ) {
             answer[list.get(i).getIdx()] = i + 1;
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}



/**
 * 순서와 응급도
 */
class Injury implements Comparable<Injury> {

    int idx;
    int emergency;

    public int getIdx() {
        return idx;
    }

    public Injury(int num, int emergency) {
        this.idx = num;
        this.emergency = emergency;
    }

    @Override
    public int compareTo(Injury o) { // 만약에 CompareTo가 같은객체가 아니라는 가정이면 반드시 재정의 해야한다.
        if (o.emergency == this.emergency) {
            return o.idx - this.idx;
        }

        return o.emergency - this.emergency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Injury injury = (Injury) o;
        return idx == injury.idx && emergency == injury.emergency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idx, emergency);
    }
}