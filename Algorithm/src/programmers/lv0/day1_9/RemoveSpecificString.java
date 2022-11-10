package programmers.lv0.day1_9;

public class RemoveSpecificString {
    public static String solution(String my_string, String letter) {
        String answer = "";
        answer = my_string.replace(letter, "");
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("HHello", "H"));
    }
}
