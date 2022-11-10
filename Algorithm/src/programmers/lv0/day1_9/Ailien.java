package programmers.lv0.day1_9;

public class Ailien {

    public static String solution(int age) {
        StringBuilder answer = new StringBuilder();
        String stringAge = String.valueOf(age);
        String[] splitAge = stringAge.split("");
        char answerChar = 'a';
        int answerInt;
        for (String s : splitAge) {
            answerInt = Integer.parseInt(s);
            answer.append((char) (answerChar + answerInt));
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        String solution = solution(23);
        System.out.println(solution);
    }
}
