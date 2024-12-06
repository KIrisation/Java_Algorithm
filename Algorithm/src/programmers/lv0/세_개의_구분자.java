package programmers.lv0;

import java.util.ArrayList;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181862
 */
public class 세_개의_구분자 {

    public List<String> solution(String myStr) {
        List<String> answers = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < myStr.length(); i++) {
            char abc = myStr.charAt(i);

            if ((abc == 'a' || abc == 'b' || abc == 'c') && sb.isEmpty()) {
                answers.add(sb.toString());
                sb.setLength(0);
            } else {
                sb.append(abc);
            }
        }

        if (!sb.isEmpty()) {
            answers.add(sb.toString());
        }

        if (answers.isEmpty()) {
            answers.add("EMPTY");
        }

        return answers;
    }
}
