package programmers.lv1.kakao;

import java.util.Locale;

public class NewIdRecommend {

    public static void main(String[] args) {
        System.out.println(solution("abcdefghijklmn.p"));
    }

    public static String solution(String new_id) {
        String answer = new_id;

        answer = firstStep(answer);
        System.out.println(answer);
        answer = secondStep(answer);
        System.out.println(answer);
        answer = thirdStep(answer);
        System.out.println(answer);
        answer = fourthStep(answer);
        System.out.println(answer);
        answer = fifthStep(answer);
        System.out.println(answer);
        answer = sixthStep(answer);
        System.out.println(answer);
        answer = seventhStep(answer);

        return answer;
    }

    private static String seventhStep(String answer) {
        if (answer.length() <= 2) {
            char c = answer.charAt(answer.length() - 1);
            while (true) {
                answer += c;

                if (answer.length() == 3) {
                    break;
                }
            }
        }
        return answer;
    }

    private static String sixthStep(String answer) {
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            if (answer.endsWith(".")) {
                answer = answer.substring(0, 14);
            }
        }

        return answer;
    }

    private static String fifthStep(String answer) {
        if (answer.equals("")) {
            answer = "a";
        }
        return answer;
    }

    private static String fourthStep(String value) {
        if (value.startsWith(".")) {
            value = value.substring(1);
        }

        if (value.endsWith(".")) {
            value = value.substring(0, value.length() - 1);
        }
        return value;

    }

    private static String thirdStep(String value) {
        while (!value.equals(value.replace("..", "."))) {
            value = value.replace("..", ".");
        }
        return value;
    }

    private static String secondStep(String value) {
        String returnValue = "";
        for (int i = 0; i < value.length(); i++) {
            char verificationLetter = value.charAt(i);

            if (Character.isLowerCase(verificationLetter)
                    || Character.isDigit(verificationLetter)
                    || verificationLetter == '-'
                    || verificationLetter == '_'
                    || verificationLetter == '.') {

                returnValue += verificationLetter;
            }
        }

        return returnValue;
    }

    private static String firstStep(String new_id) {
        return new_id.toLowerCase(Locale.ROOT);
    }
}
