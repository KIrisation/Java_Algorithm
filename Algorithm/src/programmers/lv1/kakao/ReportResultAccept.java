package programmers.lv1.kakao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ReportResultAccept {

    public static void main(String[] args) {
        ReportResultAccept reportResultAccept = new ReportResultAccept();

        int[] solution = reportResultAccept.solution(new String[]{"muzi", "frodo", "apeach", "neo"},
                new String[]{"muzi frodo",
                        "apeach "
                                + "frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2);

        for (int i : solution) {
            System.out.print(i + " ");
        }
    }

    public int[] solution(String[] id_list, String[] report, int k) {

        Map<String, Integer> receiveEmails = new HashMap<>(); // key는 아아디, value는 받을 메일 수
        Map<String, Set<String>> reportedMemory = new HashMap<>(); // key는 신고 당한 아이디, value는 신고한 사람이 담긴 Set
        // Set 사용의 이유? A 가 B를 신고하고 또 다시 A 가 B를 신고할 경우 중복으로 봐야하기 때문임.
        // 왜 신고 당한놈이 키가 되냐?? 신고 당한 사람이 신고 당한 횟수가 k 이상이 되는 사람을 찾아야 하는데
        // 그렇다면 value의 size로 해당 횟수를 알아 낼 수 있다.

        for (String s : report) {
            String[] split = s.split(" ");

            Set<String> reportedSet = reportedMemory.get(split[1]);

            if (reportedSet == null) {
                Set<String> set = new HashSet<>();
                set.add(split[0]);
                reportedMemory.put(split[1], set);
            } else {
                reportedSet.add(split[0]);
            }
        }

        for (String name : id_list) {
            if (reportedMemory.get(name) != null && reportedMemory.get(name).size() >= k) {
                Set<String> strings = reportedMemory.get(name);

                for (String string : strings) {
                    receiveEmails.compute(string, (key, value) -> value == null ? 1 : ++value);
                }
            }
        }

        int[] answer = new int[id_list.length];

        int idx = 0;
        for (String s : id_list) {
            int cnt = 0;

            if (receiveEmails.get(s) != null) {
                cnt = receiveEmails.get(s);
            }

            answer[idx] = cnt;

            ++idx;
        }

        return answer;
    }

}
