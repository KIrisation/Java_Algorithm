package programmers.lv1;

import java.util.ArrayList;
import java.util.List;

public class CaesarCode {

    public static void main(String[] args) {
        solution("z", 1);
    }

    public static String solution(String s, int n) {
        String[] splitCode = s.split("");
        char changeCode;
        List<String> changeCodes = new ArrayList<>();
        for (String s1 : splitCode) {
            if (s1.charAt(0) >= 'a' && s1.charAt(0) <= 'z') {
                changeCode = (char) (s1.charAt(0) + n);

                if (changeCode > 'z') {
                    changeCode = (char) (changeCode - 'z' + 'a' - 1);
                }
                changeCodes.add(String.valueOf(changeCode));
            }

            if (s1.charAt(0) >= 'A' && s1.charAt(0) <= 'Z') {
                changeCode = (char) (s1.charAt(0) + n);
                if (changeCode > 'Z') {
                    changeCode = (char) (changeCode - 'Z' + 'A' - 1);
                }
                changeCodes.add(String.valueOf(changeCode));
            }

            if (s1.equals(" ")) {
                changeCodes.add(" ");
            }
        }
        return String.join("", changeCodes);
    }
}
