package programmers.lv2.refactor;

import java.util.Arrays;

public class 호텔_대실_Refactor {

    private static final int MAX_TIME = 1440;
    private static final int CLEAN_ROOM = 10;
    private static final int[] timeTable = new int[MAX_TIME + CLEAN_ROOM];
    public int solution(String[][] book_time) {
        int answer = 0;

        Arrays.fill(timeTable, -1);

        for (String[] time : book_time) {
            String[] firstStartTimeSplit = time[0].split(":");
            int startTime = (Integer.parseInt(firstStartTimeSplit[0]) * 60) + Integer.parseInt(firstStartTimeSplit[1]);

            if (timeTable[startTime] == -1) {
                timeTable[startTime] = 1;
            }

            String[] secondEndTimeSplit = time[1].split(":");
            int endTime = (Integer.parseInt(secondEndTimeSplit[1]) * 60) + Integer.parseInt(secondEndTimeSplit[1]);
            if (timeTable[endTime] == -1) {
                timeTable[endTime] = 1;
            }
        }
        return answer;
    }

}
