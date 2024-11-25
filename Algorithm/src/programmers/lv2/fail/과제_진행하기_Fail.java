package programmers.lv2.fail;

import java.util.*;

/**
 * 실패 이유 리스트의 정렬까지는 성공했으나, 이후 큐와 스택을 활용하여 해당 문제를 풀 수 없었음
 * 정확하게는 시간을 너무 오래 잡아먹음
 *
 * 큐와 스택을 이용한 풀이를 기반으로 해당 코드를 다시 풀이할 예정
 */
public class 과제_진행하기_Fail {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];

        List<Homework> homeworks = new ArrayList<>();
        for (int i = 0; i < plans.length; i++) {
            String[] timeSplit = plans[i][1].split(":");

            int startTimeForMinute = Integer.parseInt(timeSplit[0]) * 60;
            startTimeForMinute += Integer.parseInt(timeSplit[1]);

            homeworks.add(new Homework(plans[i][0], startTimeForMinute, Integer.parseInt(plans[i][2])));
        }

        homeworks.sort(Comparator.naturalOrder());


        return answer;
    }
}

class Homework implements Comparable<Homework> {
    private final String name;
    private final Integer start;
    private Integer playtime;

    public Homework(String name, Integer start, Integer playtime) {
        this.name = name;
        this.start = start;
        this.playtime = playtime;
    }

    public String getName() {
        return this.name;
    }

    public Integer getStart() {
        return this.start;
    }

    public void setPlaytime(Integer nextStart) {
        this.playtime -= (nextStart - this.start);
    }

    public Integer getPlaytime() {
        return this.playtime;
    }

    @Override
    public int compareTo(Homework o1) {
        return this.getStart() - o1.getStart(); // 1440 - 60 큰 수를 뒤로
    }
}