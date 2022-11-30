package programmers.lv1;

public class GetMiddleLetter {

    public static void main(String[] args) {

    }

    public String solution(String s) {
        String answer = "";
        if (s.length() % 2 == 0) {
            answer = String.valueOf(s.charAt((s.length() / 2) - 1) + s.charAt(s.length() / 2));
        }

        if (s.length() % 2 == 1) {
            answer = String.valueOf(s.charAt((s.length() -1) / 2));
        }

        return answer;
    }
}
